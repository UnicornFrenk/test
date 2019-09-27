package DAO.impl;

import DAO.AuthUserDao;
import Model.AuthUser;

import java.util.HashMap;
import java.util.Map;


public class DefaultAuthUserDao implements AuthUserDao {

    Map<String, AuthUser> userByUserName;

    public DefaultAuthUserDao() {
        this.userByUserName = new HashMap<>();
        this.userByUserName.putIfAbsent("admin", new AuthUser("admin", "admin", null, AuthUser.ROLE.ADMIN));
        this.userByUserName.putIfAbsent("user", new AuthUser("user", "user", null, AuthUser.ROLE.USER));
    }

    private static volatile AuthUserDao instance;

    public static AuthUserDao getInstance() {
        AuthUserDao localInstance = instance;
        if (localInstance == null) {
            synchronized (AuthUserDao.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultAuthUserDao();
                }
            }
        }
        return localInstance;
    }

    @Override
    public AuthUser getByUserName(String userName) {
        return userByUserName.get(userName);
    }

    public void saveAuthUser(AuthUser user) {
        userByUserName.putIfAbsent(user.getUserName(), user);

    }
}
