package com.github;

import com.github.hib.entity.Role;
import com.github.model.Person;

import java.util.List;

public interface PersonService {
    int createPerson(Person person);

    Person getByLogin(String login);
    Person getByRole(Role role);

    void updatePerson(String login, String pass);
    void deletePerson(String login);
     List<Person> getPersons();
    List<Person> getAll();
}
