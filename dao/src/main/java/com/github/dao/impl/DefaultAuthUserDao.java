package com.github.dao.impl;

import com.github.dao.AuthUserDao;
import com.github.hib.entity.Role;
import com.github.jdbc.JDBCConnection;
import com.github.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DefaultAuthUserDao implements AuthUserDao {

    private static class SingletonHolder {
        static final AuthUserDao HOLDER_INSTANCE = new DefaultAuthUserDao();
    }

    public static AuthUserDao getInstance() {
        return DefaultAuthUserDao.SingletonHolder.HOLDER_INSTANCE;
    }
    //private static volatile AuthUserDao instance = null;

    private static final String createAuthUser = "insert into auth_users (login, password, role) values (?,?,?)";
    private static final String getRole = "select * from db.auth_users where login = ? and password = ?";
    private static final String getByLogin = "select * from db.auth_users where login = ?";


//    public static AuthUserDao getInstance() {
//        AuthUserDao localInstance = instance;
//        if (localInstance == null) {
//            synchronized (AuthUserDao.class) {
//                localInstance = instance;
//                if (localInstance == null) {
//                    instance = localInstance = new DefaultAuthUserDao();
//                }
//            }
//        }
//        return localInstance;
//    }

    @Override
    public Person create(Person authUser) {
        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(createAuthUser, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, authUser.getLogin());
            preparedStatement.setString(2, authUser.getPassword());
            preparedStatement.setString(3, String.valueOf(Role.USER));
            boolean isSuccess = preparedStatement.executeUpdate() > 0;
            if (isSuccess) {
                int id;
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    generatedKeys.next();
                    id = generatedKeys.getInt(1);
                }
                authUser.setId(id);
                return authUser;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static final String deleteUser = "delete from auth_users where login = ?";

    @Override
    public int deleteUser(String name) {

        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(deleteUser)) {
            preparedStatement.setString(1, name);
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public Person getByLogin(String login) {

        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(getByLogin)) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id_auth");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");
                    Role roleEnum = Role.valueOf(role);
                    return new Person(id, login, password, roleEnum);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private Person userEntity(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id_auth"));
        person.setLogin(rs.getString("login"));
        person.setPassword(rs.getString("password"));
        person.setRole(Role.valueOf(rs.getString("role")));

        return person;
    }

    private static final String getAllUser = "SELECT * FROM db.auth_users";

    @Override
    public List<Person> getAll() {
        try (Connection connection = JDBCConnection.connect()) {
            PreparedStatement statement = connection.prepareStatement(getAllUser);
            List<Person> userList;
            try (ResultSet resultSet = statement.executeQuery()) {
                userList = new ArrayList<>();
                while (resultSet.next()) {
                    userList.add(userEntity(resultSet));
                }
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getRole(String login, String password) {
        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(getRole)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id_auth");
                String role = resultSet.getString("role");
                System.out.println(Person.class.toString());
                System.out.println("id=" + id + "," + "login=" + login + "," + "password=" + password + "," + "role =" + role);
                return role;

            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
