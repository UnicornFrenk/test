package com.github.hib.dao;

import com.github.hib.entity.Item;
import com.github.hib.util.EntityManagerUtil;

import javax.persistence.EntityManager;

public class ItemDao {
    public void save(Item item) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();
    }
}
