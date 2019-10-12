package DAO.impl;

import Model.AuthUser;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultAuthUserDaoTest {

    @Test
    public void getInstance() {
        DefaultAuthUserDao.getInstance();
    }

    @Test
    public void create() {
        AuthUser testUSer = new AuthUser("Lola","Lola", AuthUser.ROLE.USER);
        DefaultAuthUserDao.getInstance().create(testUSer);
    }

    @Test
    public void getByLogin() {
        DefaultAuthUserDao.getInstance().getByLogin("Sofia");

    }

    @Test
    public void saveAuthUser() {
        AuthUser testUser = new AuthUser("Sofia", "Sofia", AuthUser.ROLE.USER);
        DefaultAuthUserDao.getInstance().saveAuthUser(testUser);
        System.out.println(testUser.toString());
    }

    @Test
    public void getAll() {
        DefaultAuthUserDao.getInstance().getAll();
        System.out.println(AuthUser.class.toString());
    }

    @Test
    public void getRole() {
        DefaultAuthUserDao.getInstance().getRole("Sofia", "Sofia");
    }
}