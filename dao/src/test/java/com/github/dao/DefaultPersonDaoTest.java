package com.github.dao;

import com.github.hib.dao.impl.DefaultPersonDao;
import com.github.hib.entity.Role;
import com.github.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DefaultPersonDaoTest {

    @Test
    public void getInstance() {
        DefaultPersonDao.getInstance();
    }

    @Test
    public void create() {
        Person test = new Person("Lola","Lola", Role.USER);
        DefaultPersonDao.getInstance().createPerson(test);
        String login = test.getLogin();
        String exp = "Lola";
        assertEquals( exp,login);

    }

    @Test
    public void getByLogin() {
        Person person = new Person("Sofia1","Sofia1", Role.USER);
        DefaultPersonDao.getInstance().createPerson(person);
        Person test =  DefaultPersonDao.getInstance().getByLogin("Sofia");
        String password = test.getPassword();
        String expPassword = "Sofia";
        assertEquals(expPassword,password);

    }


    @Test
    public void getAll() {
        List<Person> expected = DefaultPersonDao.getInstance().getAll();
        assertNotNull(expected);
    }

    @Test
    public void getRole() {
        Person person = new Person("Sofia","Sofia", Role.USER);
        DefaultPersonDao.getInstance().createPerson(person);
        Role role = DefaultPersonDao.getInstance().getByLogin("Sofia").getRole();
        Role exp = Role.USER;
        assertEquals( exp,role);

    }
}