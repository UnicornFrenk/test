package Dao;


import Model.AuthUser;

import java.util.List;

public interface AuthUserDao {
    AuthUser getByLogin(String login);

    void saveAuthUser(AuthUser user);

    List<AuthUser> getAll();

    AuthUser.ROLE getRole(String login, String password);

    AuthUser create(AuthUser authUser);

    int deleteUser(String name);
}
