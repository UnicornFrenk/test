package com.github.impl;

import com.github.hib.dao.PersonDao;
import com.github.hib.dao.impl.DefaultPersonDao;
import com.github.model.Person;
import com.github.SecurityService;

public class DefaultSecurityService implements SecurityService {


    private static class SingletonHolder {
        static final SecurityService HOLDER_INSTANCE = new DefaultSecurityService();
    }

    public static SecurityService getInstance() {
        return DefaultSecurityService.SingletonHolder.HOLDER_INSTANCE;}


       private PersonDao personDao = DefaultPersonDao.getInstance();

        public Person userName (String login, String password){
            Person user = personDao.getByLogin(login);
            if (user == null) {
                return null;
            }
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        }
    }

