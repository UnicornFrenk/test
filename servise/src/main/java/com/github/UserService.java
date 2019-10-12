package com.github;

import Model.AuthUser;
import Model.User;

import java.util.List;

public interface UserService {

    AuthUser getByLogin(String login);

    List<AuthUser> getAll();

    AuthUser.ROLE getRole(String login, String password);

    AuthUser create(AuthUser authUser);


}
