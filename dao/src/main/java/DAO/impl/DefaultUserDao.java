package DAO.impl;

import DAO.UserDAO;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class DefaultUserDao implements UserDAO {

    public static volatile UserDAO instance;

    public DefaultUserDao(){
        this.users = new ArrayList<>();
    }

    public static UserDAO getInstance(){
        UserDAO localInstance =instance;
        if (localInstance == null){
            synchronized (UserDAO.class){
                localInstance=instance;
                if(localInstance==null){
                    instance = localInstance = new DefaultUserDao();
                }
            }
        }
        return localInstance;
    }

    private List<User> users;

    public  List<User> getUsers(){
        return users;
    }

    public String save(User user){
        users.add(user);
        return user.getId();
    }
}
