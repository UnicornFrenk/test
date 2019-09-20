package DAO;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final List<User> store = new ArrayList<User>();

    public User getById(int id) {

        User result = new User();
        result.setId(-1);

        for (User user : store) {
            if (user.getId() == id) {
                result = user;
            }
        }
        return result;
    }


    public User getUserByLoginAndPassword(final String userName, final String password) {
        User result = new User();
        result.setId(-1);

        for (User user : store) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                result = user;
            }
        }
        return result;
    }


    public boolean add(final User user) {
        for (User user1 : store) {
            if (user1.getUserName().equals(user.getUserName()) && user1.getPassword().equals(user.getPassword())) {
                return false;
            }
        }

        return store.add(user);
    }


    public User.ROLE getRoleByLoginAndPassword(final String userName, final String password){
        User.ROLE result =User.ROLE.UNKNOWN;
        for (User user:store)
        {
            if (user.getUserName().equals(userName)&&user.getPassword().equals(password)){
                result = user.getRole();
            }
        }
        return result;
    }


    public boolean userIsExist (final String login, final String password){
        boolean result = false;

        for(User user: store ){
            if (user.getUserName().equals(login)&&user.getPassword().equals(password)){
                result = true;
                break;
            }
        }
        return result;
    }
    }
