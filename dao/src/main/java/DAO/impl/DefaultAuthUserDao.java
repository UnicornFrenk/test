package DAO.impl;

import DAO.AuthUserDao;
import Model.AuthUser;
import com.github.DataSource;
import com.github.JDBCConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DefaultAuthUserDao implements AuthUserDao {

    private static volatile AuthUserDao instance = null;

    private static final String createUser = "Insert into user (userName, password) VALUES (?, ?)";
    private static final String updateUser = "UPDATE user SET password WHERE idUser=?";
    private static final String readUserById = "SELECT * FROM user WHERE idUser=?";
    private static final String deleteUser = "DELETE FROM user WHERE idUser=?";
    private static final String getAllUser = "SELECT * FROM user";
    private static final String getRole = "select * from user where userName = ? and password = ?";
    private static final String getUserByName = "select * from user where userName =?";


    private PreparedStatement psCreateUser;
    private PreparedStatement psUpdateUser;
    private PreparedStatement psReadUserById;
    private PreparedStatement psDeleteUser;
    private PreparedStatement psGetAllUser;
    private PreparedStatement psGetRole;
    private PreparedStatement psGetUserByName;


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
    public AuthUser getByLogin(String userName) {

        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement("select * from auth_users where login = ?")) {
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id_auth");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                AuthUser authUser = new AuthUser();
                if (authUser.getRole().equals(AuthUser.ROLE.ADMIN)) {
                    return new AuthUser(id, login, password, AuthUser.ROLE.ADMIN);
                } else {
                    return new AuthUser(id, login, password, AuthUser.ROLE.USER);
                }
            } // todo fix role
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveAuthUser(AuthUser user) {

    }


    private AuthUser userEntity(ResultSet rs) throws SQLException {
        AuthUser userEntity = new AuthUser();
        userEntity.setId(rs.getLong(1));
        userEntity.setLogin(rs.getString(2));
        userEntity.setPassword(rs.getString(3));
        userEntity.setRole(AuthUser.ROLE.valueOf(rs.getString(4)));

        return userEntity;
    }

    @Override
    public List<AuthUser> getAll() {
        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(getAllUser)) {
            //todo statement?
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id_auth");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                List<AuthUser> userList = new ArrayList<>();
                while (resultSet.next()) {
                    userList.add(userEntity(resultSet));
                } return userList;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public AuthUser getRole(String login, String password) {
        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(getRole)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id_auth");
                String role = resultSet.getString("role");
                AuthUser authUser = new AuthUser();
                if (authUser.getRole().equals(AuthUser.ROLE.ADMIN)) {
                    return new AuthUser(id, login, password, AuthUser.ROLE.ADMIN);
                } else {
                    return new AuthUser(id, login, password, AuthUser.ROLE.USER);
                }
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
