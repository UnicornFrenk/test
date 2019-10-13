package Dao.impl;

import Dao.AuthUserDao;
import Dao.UserDao;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class DefaultUserDao implements UserDao {

    private static class SingletonHolder {
        static final UserDao HOLDER_INSTANCE = new DefaultUserDao();
    }
    public static UserDao getInstance() {
        return DefaultUserDao.SingletonHolder.HOLDER_INSTANCE;
    }
    //public static volatile UserDao instance;

    public DefaultUserDao(){
        this.users = new ArrayList<>();
    }

//    public static UserDao getInstance(){
//        UserDao localInstance =instance;
//        if (localInstance == null){
//            synchronized (UserDao.class){
//                localInstance=instance;
//                if(localInstance==null){
//                    instance = localInstance = new DefaultUserDao();
//                }
//            }
//        }
//        return localInstance;
//    }

    private List<User> users;

    public  List<User> getUsers(){
        return users;
    }

    public String save(User user){
        users.add(user);
        return user.getId();
//        execute("insert into user values(" + user.getLogin())
    }
}
