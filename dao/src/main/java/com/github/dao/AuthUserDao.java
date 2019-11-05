package com.github.dao;


import com.github.hib.entity.Role;
import com.github.model.Person;

import java.util.List;

public interface AuthUserDao {
    Person getByLogin(String login);


    List<Person> getAll();

    Role getRole(String login, String password);

    Person create(Person authUser);

    int deleteUser(String name);

}
