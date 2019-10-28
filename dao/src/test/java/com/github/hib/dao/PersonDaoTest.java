package com.github.hib.dao;

import com.github.hib.entity.Person;
import com.github.hib.entity.Role;
import com.github.hib.util.EntityManagerUtil;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;


public class PersonDaoTest {

    @Before
    public void init() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager("com.github.hib");
    }

    @Test
    public void testSave() {
        Person testPerson = new Person(null, "Fok", "Test", Role.USER);
        PersonDao uDao = new PersonDao();
        uDao.save(testPerson);
    }

}
