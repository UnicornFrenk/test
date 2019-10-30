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
        Order order = new Order(3,2,300,new Address());
        Person person = new Person( 88, "Sara121", "kkk", Role.USER);
        person.getOrders().add(order);
        session.beginTransaction();

        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(order);
        em.flush();
        em.getTransaction().commit();

        em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        order = em.find(Order.class, order.getId());

        Order forDelete = person.getOrders().iterator().next();

        person.getOrders().remove(forDelete);
//        forDelete.setDepartment(null);
        em.getTransaction().commit();

        session.save(order);
        session.getTransaction().commit();
        session.close();
    }


    public static void cleanUp() {
        EntityManagerUtil.closeEMFactory();
    }
}
