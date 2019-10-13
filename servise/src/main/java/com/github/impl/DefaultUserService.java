package com.github.impl;

import Dao.impl.DefaultAuthUserDao;
import Dao.impl.DefaultItemDao;
import Dao.impl.DefaultUserDao;
import Model.AuthUser;
import com.github.UserService;

import java.util.List;

public class DefaultUserService implements UserService {

    private static class SingletonHolder {
        static final UserService HOLDER_INSTANCE = new DefaultUserService();
    }

    public static UserService getInstance() {
        return DefaultUserService.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public AuthUser getByLogin(String login) {
        return DefaultAuthUserDao.getInstance().getByLogin(login);
    }

    @Override
    public List<AuthUser> getAll() {
        return DefaultAuthUserDao.getInstance().getAll();
    }

    @Override
    public AuthUser.ROLE getRole(String login, String password) {
        return DefaultAuthUserDao.getInstance().getRole(login, password);
    }

    @Override
    public AuthUser create(AuthUser authUser) {
        return DefaultAuthUserDao.getInstance().create(authUser);
    }

    @Override
    public AuthUser saveUser(AuthUser user) {
        return user;
    }

    @Override
    public int deleteUser(String name) {
        return DefaultAuthUserDao.getInstance().deleteUser(name);
    }


}
