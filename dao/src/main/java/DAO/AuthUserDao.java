package DAO;


import Model.AuthUser;

public interface AuthUserDao {
    AuthUser getByLogin (String login);
    void saveAuthUser (AuthUser user);
}
