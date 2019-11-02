package com.github.hib.dao;

import com.github.hib.entity.*;
import com.github.hib.util.EntityManagerUtil;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

import static com.github.hib.entity.Role.ADMIN;
import static com.github.hib.entity.Role.USER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HQLTestPerson {
        @BeforeAll
        static public void init() {

            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            PersonDetails personDetails = new PersonDetails(null,null,null,null,null, null);
            PersonEntity person = new PersonEntity(null, "user1", "user1", Role.USER, personDetails);
            personDetails.setPerson(person);

            em.persist(person);

            em.persist(new PersonEntity(null, "user2", "user2",Role.USER, null));
            em.persist(new PersonEntity(null, "user3", "user3",Role.USER, null));
            em.persist(new PersonEntity(null, "user4", "user4",Role.USER, null));
            em.persist(new PersonEntity(null, "user5", "user5",Role.USER, null));
            em.persist(new PersonEntity(null, "ADMIN", "ADMIN", ADMIN, null));
            em.persist(new PersonEntity(null, "user6", "user6", Role.USER, null));
            em.persist(new PersonEntity(null, "user7", "user7",Role.USER, null));
            em.persist(new PersonEntity(null, "user8", "user8",Role.USER, null));
            em.persist(new PersonEntity(null, "user9", "user9",Role.USER, null));
            em.persist(new PersonEntity(null, "user10", "user10",Role.USER, null));
            em.persist(new PersonEntity(null, "ADMIN2", "ADMIN2", ADMIN, null));

            em.getTransaction().commit();
            em.clear();
            em.close();
        }

        @Test
        public void selectPerson() {
            Session session = EntityManagerUtil.getSession();
            Query query = session.createQuery("select pd.userId, pd.city from PersonEntity as p left outer join PersonDetails as pd on p.id =pd.userId ");
            // timeout - в milliseconds
            query.setTimeout(1000)
                    // включить в кеш запросов
                    .setCacheable(true)
                    // добавлять в кэш, но не считывать из него
                    .setCacheMode(CacheMode.REFRESH)
                    .setHibernateFlushMode(FlushMode.COMMIT);
            // сущности и коллекции помечаюся как только для чтения
            //.setReadOnly(true);

            System.out.println(query.list());
        }

    @Test
    public void selectPersonWhere() {
        Session session = EntityManagerUtil.getSession();
        Role role = USER;
        Query query = session.createQuery("from PersonEntity as p where p.role =:role");
        query.setParameter("role", role)
                .getResultList().forEach(System.out::println);
    }

        @Test
        public void selectAll() {
            Session session = EntityManagerUtil.getSession();

            List<PersonEntity> list = session.createQuery("from PersonEntity as p").list();

            assertFalse(list.isEmpty());
            assertEquals(list.get(0).getLogin(), "user1");
            assertNotNull(list.get(0).getId());
        }

        @Test
        public void selectAllLogin() {
            Session session = EntityManagerUtil.getSession();
            Query query = session.createQuery("select p.login from PersonEntity as p");
            final List<String> list = query.list();
            list.forEach(System.out::println);
        }

        @Test
        public void selectTestClauseObject() {
            Session session = EntityManagerUtil.getSession();
            Query query = session.createQuery("select p.login from PersonEntity as p");
            query.list().forEach(System.out::println);
        }

        @Test
        public void selectTestClauseObjectWhere() {
            Session session = EntityManagerUtil.getSession();
            Query query = session.createQuery("select p.login from PersonEntity as p where p.login= 'ADMIN'");
            query.list().forEach(System.out::println);
        }

        @Test
        public void orderByTest() {
            Session session = EntityManagerUtil.getSession();
            Query query = session.createQuery("from PersonEntity as p order by p.id desc");
            query.list().forEach(System.out::println);
        }

        @Test
        public void parameterTest() {
            Session session = EntityManagerUtil.getSession();
            String name = "user1";
            // Query badQuery = session.createQuery("from Employee e where e.name = " + name);
            Query query = session.createQuery("from PersonEntity p where p.login = :name");
            query.setParameter("name", name)
                    .getResultList().forEach(System.out::println);
        }

        @Test
        public void parameterOrderTest() {
            Session session = EntityManagerUtil.getSession();
            Query query = session.createQuery(
                    "from PersonEntity p where p.login= ?0 and p.id > :id");
            query.setParameter(0, "User3")
                    .setParameter("id", 3)
                    .getResultList().forEach(System.out::println);
        }

        @Test
        public void parameterListTest() {
            Session session = EntityManagerUtil.getSession();
            final List<Integer> values = Arrays.asList(1, 4);
            Query query = session.createQuery("from PersonEntity p where p.id in (:ids)");
            query.setParameter("ids", values)
                    .getResultList().forEach(System.out::println);
        }

        @Test
        public void like() {
            Session session = EntityManagerUtil.getSession();
            String pattern = "use";
            Query query = session.createQuery("from PersonEntity p where p.login like :name order by p.login");
            query.setParameter("name", pattern +"%");
            System.out.println(query.list());
        }

        @Test
        public void updateEPerson() {
            Session session = EntityManagerUtil.getSession();
            session.beginTransaction();
            session.createQuery("update PersonEntity p set p.password = :pass where login = :name")
                    .setParameter("name", "User4")
                    .setParameter("pass", "123")
                    .executeUpdate();
            session.getTransaction().commit();
        }

    @Test
    public void updateEPersonRole() {
        Session session = EntityManagerUtil.getSession();
        session.beginTransaction();
        session.createQuery("update PersonEntity p set p.role = :role where login = :name")
                .setParameter("name", "User3")
                .setParameter("role", ADMIN)
                .executeUpdate();
        session.getTransaction().commit();
    }

        @Test
        public void deleteTest() {
            PersonEntity person = new PersonEntity(null, "Tuk","Tuk",Role.USER,null);
            Session session = EntityManagerUtil.getSession();
            session.getTransaction().begin();
            session.persist(person);
            session.createQuery("delete from PersonEntity p where p.login = :login")
                    .setParameter("login", person.getLogin())
                    .executeUpdate();
            session.getTransaction().commit();
        }
    @Test
    public void deleteAllUserTest() {
            PersonEntity person =new PersonEntity();
        Session session = EntityManagerUtil.getSession();
        session.getTransaction().begin();
        session.persist(person);
        session.createQuery("delete from PersonEntity p where p.role = :role")
                .setParameter("role", person.getRole())
                .executeUpdate();
        session.getTransaction().commit();
    }

        @Test
        public void aggFun() {
            Session session = EntityManagerUtil.getSession();
            Query query = session.createQuery("select max(p.id) from PersonEntity p");
            System.out.println(query.list());
        }

        @Test
        public void leftJoinTest() {
            EntityManager em = EntityManagerUtil.getEntityManager();
            List<PersonEntity> items = em.createQuery(
                    "select distinct p " +
                            "from PersonEntity p " +
                            "left outer join p.personDetails pd " +
                            "where pd.city = 'Minsk'", PersonEntity.class)
                    .getResultList();
            items.forEach(System.out::println);
        }

        @Test
        public void withJoinTest() {
            Session session = EntityManagerUtil.getSession();
            List<ItemEntity> items = session.createQuery(
                    "select distinct p " +
                            "from PersonEntity p " +
                            "inner join p.personDetails pd on pd.city = 'NY'")
                    .getResultList();
            items.forEach(System.out::println);
        }

        @Test
        public void paginationTest() {
            final List<PersonEntity> page0 = getPage(0);
            System.out.println("page 0");
            System.out.println(page0);

            final List<PersonEntity> page1 = getPage(1);
            System.out.println("page 1");
            System.out.println(page1);

            final List<PersonEntity> page2 = getPage(2);
            System.out.println("page 2");
            System.out.println(page2);
        }

        private List<PersonEntity> getPage(int page) {
            int pageSize = 2;
            Session session = EntityManagerUtil.getSession();
            Query query = session.createQuery("from PersonEntity p");
            return query.setMaxResults(pageSize)
                    .setFirstResult(page * pageSize)
                    .getResultList();
        }

        @AfterAll
        public static void cleanUp() {
            EntityManagerUtil.closeEMFactory();
        }


    }

