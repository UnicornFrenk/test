package com.github.hib.dao;

import com.github.hib.dao.converters.PersonConverter;
import com.github.hib.dao.impl.DefaultPersonDao;
import com.github.hib.entity.PersonDetails;
import com.github.hib.entity.PersonEntity;
import com.github.hib.entity.Role;
import com.github.hib.util.EntityManagerUtil;
import com.github.model.Person;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class PersonDaoTest {

    private PersonEntity savePerson() {
        Session session = EntityManagerUtil.getEntityManager();
        PersonEntity person = new PersonEntity("Matew", "mmm");
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
        return person;
    }

    @Test
    public void createPerson() {
        PersonEntity personForTest = new PersonEntity(null, "log", "pass", Role.USER, new PersonDetails());
        DefaultPersonDao.getInstance().createPerson(PersonConverter.fromEntity(personForTest));
        System.out.println(personForTest);

        Assertions.assertNotNull(personForTest);
    }

    @Test
    public void read() {
        final PersonEntity person = savePerson();
        DefaultPersonDao.getInstance().getByLogin(person.getLogin());
        System.out.println(person);

        Assertions.assertNotNull(person);
    }

    @Test
    public void updateSession() {
        final PersonEntity person = savePerson();
        DefaultPersonDao.getInstance().updatePerson(person.getLogin(), "www");
        System.out.println(person);

        Assertions.assertEquals(person.getPassword(), "www");
    }

    @Test
    public void deleteSession() {
        final PersonEntity person = savePerson();
        DefaultPersonDao.getInstance().deletePerson(person.getId());

        Assertions.assertNull(person);
    }

    @Test
    public void getAll() {
        List<PersonEntity> list = new ArrayList<>();
        PersonEntity i1 = savePerson();
        PersonEntity i2 = savePerson();
        PersonEntity i3 = savePerson();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        List<Person> expected = DefaultPersonDao.getInstance().getAll();
        System.out.println(expected);

        Assertions.assertNotNull(expected);
    }
}
