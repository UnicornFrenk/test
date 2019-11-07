package com.github.hib.dao;

import com.github.hib.entity.Role;
import com.github.model.Person;

import java.util.List;

public interface PersonDao {


    int createPerson(Person person);

    Person getByLogin(String login);
    Person getByRole(Role role);

    void updatePerson(String login, String pass);
    void deletePerson(Integer id);
    List<Person> getPersons();
    List<Person> getAll();
}
