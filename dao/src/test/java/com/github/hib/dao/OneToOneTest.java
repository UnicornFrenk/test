package com.github.hib.dao;

import com.github.hib.entity.Person;
import com.github.hib.entity.PersonDetails;
import com.github.hib.util.EntityManagerUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

public class OneToOneTest {

    @Test
    public void saveTest(){
        Person person = new Person(null,"log", "pass", null, null);
        PersonDetails personDetails = new PersonDetails(null, "Sadovaya", "Minsk", "", "Belarus", person);
        person.setPersonDetails(personDetails);
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        em.clear();

        Person personFromDb = em.find(Person.class,3L);
        Assert.assertEquals(person.getLogin(), personFromDb.getLogin());


    }

    @Test
    public void mergeCascadeTest() {
        Person person = new Person(null, "log", "pass", null, null);
        PersonDetails personDetails = new PersonDetails(null, "Sadovaya", "Minsk", "", "Belarus", person);
        person.setPersonDetails(personDetails);

        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        em.clear();

        Person personFromDb = em.find(Person.class, 1L);

        personFromDb.getPersonDetails().setCity("Kiev");
        em.getTransaction().begin();
        em.merge(personFromDb);
        em.getTransaction().commit();

        Assert.assertEquals(person.getLogin(), personFromDb.getLogin());
    }
}
