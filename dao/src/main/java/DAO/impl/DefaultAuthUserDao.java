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
import java.util.HashMap;
import java.util.Map;


public class DefaultAuthUserDao implements AuthUserDao {


    private static volatile AuthUserDao instance;

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
                if (authUser.getRole().equals(AuthUser.ROLE.ADMIN)){
                return new AuthUser(id, login, password, AuthUser.ROLE.ADMIN);}
                else {
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
}
