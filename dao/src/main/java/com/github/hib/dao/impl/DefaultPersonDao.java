package com.github.hib.dao.impl;

import com.github.hib.dao.converters.PersonConverter;
import com.github.hib.dao.PersonDao;
import com.github.hib.entity.PersonEntity;
import com.github.hib.entity.Role;
import com.github.hib.util.HibernateUtil;
import com.github.model.Person;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultPersonDao implements PersonDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultPersonDao.class);

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
    public Person updatePerson(Integer id) {
        PersonEntity personEntity;
        try {
            personEntity = (PersonEntity) HibernateUtil.getSession().createQuery("update PersonEntity p set p.role = 'ADMIN' where p.id = :id").setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            log.info("user not found by login{}", id);
            personEntity = null;
        }
        return PersonConverter.fromEntity(personEntity);
    }

    @Override
    public void deletePerson(String login) {
        PersonEntity personEntity;
        try {
            personEntity = (PersonEntity) HibernateUtil.getSession().createQuery("delete from PersonEntity p where p.login = :login").setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
            log.info("user not found by login{}", login);
            personEntity = null;
        }
    }

    @Override
    public List<Person> getAll() {
        final List<PersonEntity> personList = HibernateUtil.getSession().createQuery("from PersonEntity ").list();
        return personList.stream().map(PersonConverter::fromEntity).collect(Collectors.toList());
    }
}
