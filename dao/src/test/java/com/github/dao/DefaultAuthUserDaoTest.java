package com.github.dao;

import com.github.dao.impl.DefaultAuthUserDao;
import com.github.model.AuthUser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DefaultAuthUserDaoTest {

    @Test
    public void getInstance() {
        DefaultAuthUserDao.getInstance();
    }

    @Test
    public void create() {
        AuthUser test = new AuthUser("Lola","Lola", AuthUser.ROLE.USER);
        DefaultAuthUserDao.getInstance().create(test);
        String login = test.getLogin();
        String exp = "Lola";
        assertEquals( exp,login);

    }

    @Test
    public void getByLogin() {
        AuthUser test =  DefaultAuthUserDao.getInstance().getByLogin("Sofia");
        String password = test.getPassword();
        String expPassword = "Sofia";
        assertEquals(expPassword,password);



    }


    @Test
    public void getAll() {
        List<AuthUser> expected = DefaultAuthUserDao.getInstance().getAll();
        assertNotNull(expected);
    }

    @Test
    public void getRole() {

        AuthUser.ROLE role = DefaultAuthUserDao.getInstance().getRole("Sofia", "Sofia");
        AuthUser.ROLE exp = AuthUser.ROLE.USER;
        assertEquals( exp,role);

    }
}