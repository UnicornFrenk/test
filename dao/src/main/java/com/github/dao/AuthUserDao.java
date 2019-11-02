package com.github.dao;


import com.github.model.Person;

import java.util.List;

public interface AuthUserDao {
    Person getByLogin(String login);


    List<Person> getAll();

    String  getRole(String login, String password);

    Person create(Person authUser);

    int deleteUser(String name);

}
