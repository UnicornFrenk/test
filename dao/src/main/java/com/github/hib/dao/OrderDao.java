package com.github.hib.dao;

import com.github.hib.entity.Order;
import com.github.hib.util.EntityManagerUtil;

import javax.persistence.EntityManager;

public class OrderDao {

    public void save(Order order) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
    }
}
