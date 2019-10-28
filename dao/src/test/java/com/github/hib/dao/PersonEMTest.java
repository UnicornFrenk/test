package com.github.hib.dao;

import com.github.hib.entity.Person;
import com.github.hib.entity.Role;
import com.github.hib.util.EntityManagerUtil;
import com.github.hib.util.SessionFactoryUtil;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonEMTest {

        @Test
        public void saveTest() {
            Person person = new Person(null, "Sols", "DDD", Role.USER);
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(person);
            System.out.println("after persist");
            em.getTransaction().commit();
            em.clear();

            em.getTransaction().begin();
            Person personFromDb = em.find(Person.class, person.getId());
            Assert.assertEquals(person, personFromDb);
            em.getTransaction().commit();
        }
        @Test
        public void flushAutoJPQLTest() {
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(new Person(null, "Sosl", "DDD", Role.USER));
            entityManager.createQuery( "select i from Item  i" ).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        @Test
        public void flushAutoNativeSqlTest() {
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println(entityManager.createNativeQuery( "select count(*) from user" ).getSingleResult());
            entityManager.persist(new Person(null, "Sols", "DDD", Role.USER));
            System.out.println(entityManager.createNativeQuery( "select count(*) from user" ).getSingleResult());
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        @Test
        public void flushCommitJPQLTest() {
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Person person = new Person(null, "Admin", "Admin", Role.ADMIN);
            entityManager.persist(person);
            person.setLogin("Admin2");
            entityManager.merge(person);
//            entityManager.createQuery( "select d from Department d" )
//                    .setFlushMode(FlushModeType.COMMIT)
//                    .getResultList();
            System.out.println(entityManager.createQuery( "select p from Person p" )
                    .setFlushMode(FlushModeType.COMMIT)
                    .getResultList().size());
            System.out.println(entityManager.createQuery( "select p from Person p" )
                    .getResultList().size());
            entityManager.getTransaction().commit();
            entityManager.close();
        }

        @Test
        public void flushCommitNativeSQLTest() {
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(new Person(null, "Admin3", "Admin3", Role.ADMIN));
            System.out.println(entityManager.createNativeQuery( "select * from Person" )
                    .setFlushMode(FlushModeType.COMMIT)
                    .getResultList().size());

            System.out.println(entityManager.createNativeQuery( "select * from Person" )
                    .getResultList().size());
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        @Test
        public void flushManualTest() {
            Session session = SessionFactoryUtil.getSession();
            session.setHibernateFlushMode(FlushMode.MANUAL);
            session.getTransaction().begin();
            session.persist(new Person(null, "Adm4", "Adm4", Role.ADMIN));
            assertEquals(1, ((Number) session
                    .createNativeQuery("select count(*) from Person")
                    .uniqueResult()).intValue());
//        entityManager.flush();
            session.getTransaction().commit();
            session.close();
        }
        @Test
        public void flushOperationOrderTest() {
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(new Person(null, "Adm4", "Adm4", Role.ADMIN));
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
            Person person = entityManager.find( Person.class, 1);
            System.out.println(person.getClass());
            entityManager.remove(person);

            entityManager.persist( new Person(null, "Adm4", "Adm4", Role.ADMIN) );
            entityManager.getTransaction().commit();
            entityManager.close();
        }

        @AfterClass
        public void cleanUp() {
            EntityManagerUtil.closeEMFactory();
        }
    }
