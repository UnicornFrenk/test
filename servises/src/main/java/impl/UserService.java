package impl;

import Model.AuthUser;
import Model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    String saveUser(User user);
    void saveAuthUser(AuthUser authUser);
}
