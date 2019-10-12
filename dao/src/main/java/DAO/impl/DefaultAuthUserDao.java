package DAO.impl;

import DAO.AuthUserDao;
import Model.AuthUser;
import com.github.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DefaultAuthUserDao implements AuthUserDao {

    private static volatile AuthUserDao instance = null;

    private static final String createAuthUser = "insert into auth_users (name_auth, login, password, role) values (?,?,?,?)";
    private static final String getRole = "select * from db.auth_users where login = ? and password = ?";
    private static final String getByLogin = "select * from db.auth_users where login = ?";


    public static AuthUserDao getInstance() {
        AuthUserDao localInstance = instance;
        if (localInstance == null) {
            synchronized (AuthUserDao.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultAuthUserDao();
                }
            }
        }
        return localInstance;
    }

    @Override
    public AuthUser create(AuthUser authUser) {
        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(createAuthUser, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, authUser.getLogin());
            preparedStatement.setString(2, authUser.getLogin());
            preparedStatement.setString(3, authUser.getPassword());
            preparedStatement.setString(4, authUser.getRole().name());
            boolean isSuccess = preparedStatement.executeUpdate() > 0;
            if (isSuccess) {
                long id;
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    generatedKeys.next();
                    id = generatedKeys.getLong(1);
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


    public AuthUser getByLogin(String login) {

        try (Connection connection = JDBCConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(getByLogin)) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong("id_auth");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");
                    AuthUser.ROLE roleEnum = AuthUser.ROLE.valueOf(role);
                    return new AuthUser(id, login, password, roleEnum);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveAuthUser(AuthUser user) {

    }


    private AuthUser userEntity(ResultSet rs) throws SQLException {
        AuthUser userEntity = new AuthUser();
        userEntity.setId(rs.getLong("id_auth"));
        userEntity.setLogin(rs.getString("login"));
        userEntity.setPassword(rs.getString("password"));
        userEntity.setRole(AuthUser.ROLE.valueOf(rs.getString("role")));

        return userEntity;
    }

    private static final String getAllUser = "SELECT * FROM db.auth_users";

    @Override
    public List<AuthUser> getAll() {
        try (Connection connection = JDBCConnection.connect()) {
            PreparedStatement statement = connection.prepareStatement(getAllUser);
            List<AuthUser> userList;
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
    public AuthUser.ROLE getRole(String login, String password) {
        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(getRole)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id_auth");
                String role = resultSet.getString("role");
                System.out.println(AuthUser.class.toString());
                System.out.println("id=" + id + "," + "login=" + login + "," + "password=" + password + "," + "role =" + role);
                return AuthUser.ROLE.valueOf(role);

            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
