package com.github.hib.dao.impl;

import com.github.hib.dao.converters.PersonConverter;
import com.github.hib.dao.PersonDao;
import com.github.hib.entity.PersonEntity;
import com.github.hib.entity.Role;
import com.github.hib.util.EntityManagerUtil;
import com.github.hib.util.HibernateUtil;
import com.github.model.Person;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultPersonDao implements PersonDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultPersonDao.class);

    private static class SingletonHolder {
        static final PersonDao HOLDER_INSTANCE = new DefaultPersonDao();
    }

    public static PersonDao getInstance() {
        return DefaultPersonDao.SingletonHolder.HOLDER_INSTANCE;
    }


    @Override
    public int createPerson(Person person) {
        PersonEntity pEntity = PersonConverter.toEntity(person);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(pEntity);
        session.getTransaction().commit();
        return pEntity.getId();
    }

    @Override
    public Person getByLogin(String login) {

        PersonEntity personEntity;
        try {
            personEntity = (PersonEntity) HibernateUtil.getSession().createQuery("from PersonEntity p where p.login = :login").setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
            log.info("user not found by login{}", login);
            personEntity = null;
        }
        return PersonConverter.fromEntity(personEntity);
    }

    @Override
    public Person getByRole(Role role) {
        PersonEntity personEntity;
        try {
            personEntity = (PersonEntity) HibernateUtil.getSession().createQuery("from PersonEntity p where p.role = :role").setParameter("role", role).getSingleResult();
        } catch (NoResultException e) {
            log.info("user not found by login{}", role);
            personEntity = null;
        }
        return PersonConverter.fromEntity(personEntity);
    }

    @Override
    public void updatePerson(String login, String pass) {
        pass = "www";
        try {
            HibernateUtil
                    .getSession()
                    .createQuery("update PersonEntity p set p.password = :pass where p.login = :login")
                    .setParameter("login", login)
                    .setParameter("pass",pass)
                    .executeUpdate();
        } catch (NoResultException e) {
            log.info("user not found by login{}", login);
        }
    }

    @Override
    public void deletePerson(String login) {
        PersonEntity personEntity;
        try {
            personEntity = (PersonEntity) HibernateUtil
                    .getSession()
                    .createQuery("delete from PersonEntity p where p.login = :login")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("user not found by login{}", login);
            personEntity = null;
        }
    }

    @Override
    public List<Person> getAll() {
        final List<PersonEntity> personList = HibernateUtil
                .getSession()
                .createQuery("from PersonEntity ")
                .list();
        return personList
                .stream()
                .map(PersonConverter::fromEntity)
                .collect(Collectors.toList());
    }

    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        CriteriaBuilder cb = EntityManagerUtil.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
        Root<Person> personRoot = criteria.from(Person.class);
        criteria.select(personRoot);
        List<Person> personsFromDB = EntityManagerUtil.getEntityManager().createQuery(criteria).getResultList();
        if (personsFromDB.size() > 0) {
            personsFromDB.forEach(room -> personList.add(new Person()));
            return personList;
        }
        return null;
    }
}
