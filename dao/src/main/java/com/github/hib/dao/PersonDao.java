package com.github.hib.dao;

import com.github.hib.entity.Person;
import com.github.hib.util.EntityManagerUtil;

import javax.persistence.EntityManager;

public class PersonDao {
    public void save(Person user) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
