package impl;

import DAO.AuthUserDao;
import DAO.impl.DefaultAuthUserDao;
import Model.AuthUser;

public class DefaultSecurityService implements SecurityService{
    private AuthUserDao authUserDao = DefaultAuthUserDao.getInstance();

    private static volatile SecurityService instance;

    public static SecurityService getInstance() {
        SecurityService localInstance = instance;
        if (localInstance == null) {
            synchronized (SecurityService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultSecurityService();
                }
            }
        }
        return localInstance;
    }

    public AuthUser userName(String userName, String password) {
        AuthUser user = authUserDao.getByUserName(userName);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}

