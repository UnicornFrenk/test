package DAO;


import Model.AuthUser;

import java.sql.SQLException;
import java.util.List;

public interface AuthUserDao {
    AuthUser getByLogin (String login);
    void saveAuthUser (AuthUser user);
    List<AuthUser> getAll();
    AuthUser getRole(String login, String password);
}
