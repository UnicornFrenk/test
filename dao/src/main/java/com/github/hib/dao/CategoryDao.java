package com.github.hib.dao;

import com.github.hib.entity.Category;
import com.github.hib.util.EntityManagerUtil;

import javax.persistence.EntityManager;

public class CategoryDao {
    public void save(Category category) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
    }
}
