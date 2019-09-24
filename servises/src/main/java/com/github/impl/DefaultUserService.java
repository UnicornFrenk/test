package com.github.impl;

import DAO.UserDAO;
import DAO.impl.DefaultUserDao;
import Model.AuthUser;
import Model.User;
import com.github.UserService;

import java.util.List;

    public class DefaultUserService implements UserService {
        private UserDAO userDao = DefaultUserDao.getInstance();

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
        public List<User> getUsers() {
            return userDao.getUsers();
        }

        @Override
        public String saveUser(User user) {
            return userDao.save(user);
        }

        @Override
        public void saveAuthUser(AuthUser authUser) {

        }
    }
