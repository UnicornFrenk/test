package com.github.impl;

import com.github.PersonService;
import com.github.hib.dao.PersonDao;
import com.github.hib.dao.impl.DefaultPersonDao;
import com.github.hib.entity.Role;
import com.github.model.Person;

import java.util.List;

public class DefaultPersonService implements PersonService {

    private PersonDao personDao = DefaultPersonDao.getInstance();

    private static class SingletonHolder {
        static final PersonService HOLDER_INSTANCE = new DefaultPersonService();
    }

    public static PersonService getInstance() {

        return DefaultPersonService
                .SingletonHolder
                .HOLDER_INSTANCE;
    }

    @Override
    public int createPerson(Person person) {
        return personDao.createPerson(person);
    }

    @Override
    public Person getByLogin(String login) {
        return personDao.getByLogin(login);
    }

    @Override
    public Person getByRole(Role role) {
        return personDao.getByRole(role);
    }

    @Override
    public void updatePerson(String login, String pass) {
        personDao.updatePerson(login,pass);
    }

    @Override
    public void deletePerson(Integer id) {
        personDao.deletePerson(id);

    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }
}
