package DAO;


import Model.AuthUser;

public interface AuthUserDao {
    AuthUser getByUserName (String userName);
    void saveAuthUser (AuthUser user);
}
