package com.github.dao;

import com.github.dao.impl.DefaultAuthUserDao;
import com.github.hib.entity.Role;
import com.github.model.Person;
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
        Person test = new Person("Lola","Lola", Role.USER);
        DefaultAuthUserDao.getInstance().create(test);
        String login = test.getLogin();
        String exp = "Lola";
        assertEquals( exp,login);

    }

    @Test
    public void getByLogin() {
        Person test =  DefaultAuthUserDao.getInstance().getByLogin("Sofia");
        String password = test.getPassword();
        String expPassword = "Sofia";
        assertEquals(expPassword,password);



    }


    @Test
    public void getAll() {
        List<Person> expected = DefaultAuthUserDao.getInstance().getAll();
        assertNotNull(expected);
    }

    @Test
    public void getRole() {

        String role = DefaultAuthUserDao.getInstance().getRole("Sofia", "Sofia");
        Role exp = Role.USER;
        assertEquals( exp,role);

    }
}