package com.github.hib.dao;

import com.github.hib.entity.*;
import com.github.hib.util.EntityManagerUtil;
import com.github.hib.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

public class OneToManyTest {
    @Test
    public void saveTest() {



        Session session = HibernateUtil.getSession();
        CategoryEntity category = new CategoryEntity("fruits");
        ItemEntity item = new ItemEntity(null, "pomme", "sweet", 200, 300, category);
        category.getItems().add(item);

        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(category);
        em.flush();
        em.getTransaction().commit();

        em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        category = em.find(CategoryEntity.class, category.getIdCategory());

        ItemEntity itemForDel = category.getItems().iterator().next();

        category.getItems().remove(itemForDel);
//        forDelete.setDepartment(null);
        em.getTransaction().commit();

        session.save(item);
        session.getTransaction().commit();
        session.close();
    }


    public static void cleanUp() {
        EntityManagerUtil.closeEMFactory();
    }
}
