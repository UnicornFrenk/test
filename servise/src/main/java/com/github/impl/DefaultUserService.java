package com.github.impl;

import DAO.AuthUserDao;
import DAO.UserDAO;
import DAO.impl.DefaultAuthUserDao;
import DAO.impl.DefaultUserDao;
import Model.AuthUser;
import Model.User;
import com.github.UserService;

import java.util.List;

public class DefaultUserService implements UserService {
    //private UserDAO userDao = DefaultUserDao.getInstance();
    private AuthUserDao authUserDao = DefaultAuthUserDao.getInstance();

    private static volatile UserService instance;


    public static UserService getInstance() {
        UserService localInstance = instance;
        if (localInstance == null) {
            synchronized (UserService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultUserService();
                }
            }
        }
        return localInstance;
    }


    @Override
    public AuthUser getByLogin(String login) {
        return authUserDao.getByLogin(login);
    }

    @Override
    public List<AuthUser> getAll() {
        return authUserDao.getAll();
    }

    @Override
    public AuthUser.ROLE getRole(String login, String password) {
        return authUserDao.getRole(login, password);
    }

    @Override
    public AuthUser create(AuthUser authUser) {
        return authUserDao.create(authUser);
    }


}
