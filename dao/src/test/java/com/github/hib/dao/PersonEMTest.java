package com.github.hib.dao;

import com.github.hib.entity.PersonEntity;
import com.github.hib.entity.Role;
import com.github.hib.util.EntityManagerUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;

public class PersonEMTest {

    @Test
    public void saveTest() {
        PersonEntity person = new PersonEntity(null, "Sols", "DDD", Role.USER,null);
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        System.out.println("after persist");
        em.getTransaction().commit();
        em.clear();

        em.getTransaction().begin();
        PersonEntity personFromDb = em.find(PersonEntity.class, person.getId());
        Assertions.assertEquals(person, personFromDb);
        em.getTransaction().commit();
    }



    @Test
    public void flushAutoJPQLTest() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new PersonEntity(null, "Sosl", "DDD", Role.USER,null));
        entityManager.createQuery("select i from ItemEntity  i").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void flushAutoNativeSqlTest() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        System.out.println(entityManager.createNativeQuery("select count(*) from user").getSingleResult());
        entityManager.persist(new PersonEntity(null, "Sols", "DDD", Role.USER,null));
        System.out.println(entityManager.createNativeQuery("select count(*) from user").getSingleResult());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void flushCommitJPQLTest() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        PersonEntity person = new PersonEntity(null, "Admin", "Admin", Role.ADMIN,null);
        entityManager.persist(person);
        person.setLogin("Admin2");
        entityManager.merge(person);
//            entityManager.createQuery( "select d from Department d" )
//                    .setFlushMode(FlushModeType.COMMIT)
//                    .getResultList();
        System.out.println(entityManager.createQuery("select p from PersonEntity p").setFlushMode(FlushModeType.COMMIT).getResultList().size());
        System.out.println(entityManager.createQuery("select p from PersonEntity p").getResultList().size());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void flushCommitNativeSQLTest() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new PersonEntity(null, "Admin3", "Admin3", Role.ADMIN, null));
        System.out.println(entityManager.createNativeQuery("select * from user").setFlushMode(FlushModeType.COMMIT).getResultList().size());

        System.out.println(entityManager.createNativeQuery("select * from user").getResultList().size());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

//    @Test
//    public void flushManualTest() {
//        Session session = EntityManagerUtil.getSession();
//        session.setHibernateFlushMode(FlushMode.MANUAL);
//        session.getTransaction().begin();
//        session.persist(new PersonEntity(null, "Adm4", "Adm4", Role.ADMIN));
//        assertEquals(2, ((Number) session.createNativeQuery("select count(*) from user").uniqueResult()).intValue());
////        entityManager.flush();
//        session.getTransaction().commit();
//        session.close();
//    }

    @Test
    public void flushOperationOrderTest() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        PersonEntity person = new PersonEntity(null, "Adm4", "Adm4", Role.ADMIN, null);
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        PersonEntity personfromdb = entityManager.find(PersonEntity.class, person.getId());
        System.out.println(personfromdb.getClass());
        entityManager.remove(personfromdb);

        entityManager.persist(new PersonEntity(null, "Adm4", "Adm4", Role.ADMIN, null));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
