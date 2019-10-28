package com.github.dao;


import com.github.model.AuthUser;

import java.util.List;

public interface AuthUserDao {
    AuthUser getByLogin(String login);


    List<AuthUser> getAll();

    AuthUser.ROLE getRole(String login, String password);

    AuthUser create(AuthUser authUser);

    int deleteUser(String name);

}
