package com.github.hib.dao;

import com.github.hib.dao.impl.DefaultPersonDao;
import com.github.hib.entity.PersonEntity;
import com.github.hib.entity.Role;
import com.github.hib.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;


public class PersonDaoTest {

    private PersonEntity savePerson() {
        Session session = HibernateUtil.getSession();
        PersonEntity person = new PersonEntity("Matew", "mmm");
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
        return person;
    }

    @Test
    public void saveSession() {
        Session session = HibernateUtil.getSession();
        PersonEntity person = new PersonEntity("Map", "123");
        person.setRole(Role.USER);
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void updateSession() {
        final PersonEntity person = savePerson();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        person.setLogin("Ad");
        session.saveOrUpdate(person);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void deleteSession() {
        PersonEntity person = savePerson();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        person = session.get(PersonEntity.class, person.getId());
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void read() {
        final PersonEntity person = savePerson();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.get(PersonEntity.class, person.getId());
        session.getTransaction().commit();
        session.close();
    }


}
