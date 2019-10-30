//package com.github.hib.dao;
//
//import com.github.hib.entity.Address;
//import com.github.hib.entity.Person;
//import com.github.hib.entity.Role;
//import com.github.hib.util.SessionFactoryUtil;
//import org.hibernate.Session;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//
//public class SessionFactoryTest {
//
//        @Test
//        public void save() {
//            Session session = SessionFactoryUtil.getSession();
//            Person person = new Person(null, "Admin", "Admin", Role.ADMIN);
//            session.beginTransaction();
//            session.save(person);
//            System.out.println("after save");
//            session.getTransaction().commit();
//            session.close();
//        }
//
//        @Test
//        public void saveTest() {
//            Session session = SessionFactoryUtil.getSession();
//            Person person = new Person(null, "Admin", "Admin", Role.ADMIN);
//            session.beginTransaction();
//            session.save(person);
//            session.getTransaction().commit();
//            session.evict(person);
//
//            Person personFromDb = session.get(Person.class, person.getId());
//            Assert.assertEquals(person, personFromDb);
//
//            session.close();
//        }
//
//        @Test
//        public void loadTest() {
//            Person person = savePerson();
//            Session session = SessionFactoryUtil.getSession();
//            Person loadedPerson = session.load(Person.class, person.getId());
//            System.out.println("after load");
//            loadedPerson.getLogin();
//            session.close();
//        }
//
//        //@Test(expected = LazyInitializationException.class)
//        public void lazyLoadTest() {
//            Person person = savePerson();
//            Session session = SessionFactoryUtil.getSession();
//            Person loadedPerson = session.load(Person.class, person.getId());
//            System.out.println(loadedPerson.getClass());
//            session.clear();
//            loadedPerson.getLogin();
//            session.close();
//        }
//
//        @Test
//        public void getTest() {
//            Person person = savePerson();
//            Session session = SessionFactoryUtil.getSession();
//            Person loadedPerson = session.get(Person.class, person.getId());
//            System.out.println(loadedPerson.getClass());
//            session.close();
//        }
//
//        @Test
//        public void updateTest() {
//            Person person = savePerson();
//            Session session = SessionFactoryUtil.getSession();
//            session.beginTransaction();
//            Person loadedPerson = session.load(Person.class, person.getId());
//            loadedPerson.setLogin("Admin3");
//            session.getTransaction().commit();
//            session.close();
//        }
//
//        @Test
//        public void updateFlushTest() {
//            Person person = savePerson();
//            Session session = SessionFactoryUtil.getSession();
//            Person loadedPerson = session.get(Person.class, person.getId());
//            loadedPerson.setLogin("Adm4");
//            session.refresh(loadedPerson);
//            session.close();
//        }
//
//        private Person savePerson() {
//            Session session = SessionFactoryUtil.getSession();
//            Person person = new Person(null, "Admin", "Admin", Role.ADMIN);
//            session.beginTransaction();
//            session.saveOrUpdate(person);
//            session.getTransaction().commit();
//            session.close();
//            return person;
//        }
//
//        @Test
//        public void isDirtyTest() {
//            Session session = SessionFactoryUtil.getSession();
//            Person person = new Person(null, "Admin", "Admin", Role.ADMIN);
//            session.beginTransaction();
//            session.save(person);
//            session.getTransaction().commit();
//            session.close();
//
//            session = SessionFactoryUtil.getSession();
//            Person loadedPerson = session.get(Person.class, person.getId());
//            loadedPerson.setLogin("555");
//            System.out.println(session.isDirty());
//            session.close();
//        }
//
//        @Test
//         void deleteTest() {
//            Session session = SessionFactoryUtil.getSession();
//            Person personForDelete = new Person(null, "Admin", "Admin", Role.ADMIN);
//            System.out.println("Count before save " + session.createQuery("Select count(*) from Person").getSingleResult());
//            session.beginTransaction();
//            session.save(personForDelete);
//            System.out.println("Count after save " + session.createQuery("Select count(*) from Person").getSingleResult());
//            session.delete(personForDelete);
//            session.getTransaction().commit();
//            System.out.println("Count after delete " + session.createQuery("Select count(*) from Person").getSingleResult());
//            SessionFactoryUtil.closeSessionFactory();
//           // session.close();
//        }
//
//        @Test
//         void deleteExistedTest() {
//            Session session = SessionFactoryUtil.getSession();
//            Person person = new Person(null, "Admin", "Admin", Role.ADMIN);
//            session.beginTransaction();
//            session.save(person);
//            session.getTransaction().commit();
//            session.close();
//
//            session = SessionFactoryUtil.getSession();
//            session.beginTransaction();
//            Person personForDelete = session.get(Person.class, person.getId());
//            session.delete(personForDelete);
//            session.getTransaction().commit();
//
//            session.close();
//        }
//
//        @Test
//        public void flushCommitTest() {
//            Session session = SessionFactoryUtil.getSession();
//            Person person = new Person(null, "Admin", "Admin", Role.ADMIN);
//            session.beginTransaction();
//            session.save(person);
//            System.out.println("Person is persisted before commit.");
//            session.getTransaction().commit();
//            session.close();
//        }
//    }
