package com.github.hib.dao;

import com.github.hib.entity.Role;
import com.github.model.Person;

import java.util.List;

public interface PersonDao {


    int createPerson(Person person);

    Person getByLogin(String login);
    Person getByRole(Role role);

    Person updatePerson(Integer id);
    void deletePerson(String login);
    List<Person> getAll();
}
