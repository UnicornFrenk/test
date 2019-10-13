package com.github.impl;

import Dao.AuthUserDao;
import Dao.impl.DefaultAuthUserDao;
import Model.AuthUser;
import com.github.SecurityService;

public class DefaultSecurityService implements SecurityService {


    private static class SingletonHolder {
        static final SecurityService HOLDER_INSTANCE = new DefaultSecurityService();
    }

    public static SecurityService getInstance() {
        return DefaultSecurityService.SingletonHolder.HOLDER_INSTANCE;}


       private AuthUserDao authUserDao = DefaultAuthUserDao.getInstance();
//
//        private static volatile SecurityService instance;
//
//        public static SecurityService getInstance () {
//            SecurityService localInstance = instance;
//            if (localInstance == null) {
//                synchronized (SecurityService.class) {
//                    localInstance = instance;
//                    if (localInstance == null) {
//                        instance = localInstance = new DefaultSecurityService();
//                    }
//                }
//            }
//            return localInstance;
//        }

        public AuthUser userName (String login, String password){
            AuthUser user = authUserDao.getByLogin(login);
            if (user == null) {
                return null;
            }
            if (user.getPassword().equals(password)) {
                return user;
            }
            return null;
        }
    }

