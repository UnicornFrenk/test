package DAO;

import Model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    String save (User user);
    }
