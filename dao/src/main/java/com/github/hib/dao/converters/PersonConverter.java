package com.github.hib.dao.converters;

import com.github.hib.entity.PersonDetails;
import com.github.hib.entity.PersonEntity;
import com.github.model.Person;

public class PersonConverter {
    public static PersonEntity toEntity(Person person) {
        if (person == null) {
            return null;
        }
        final PersonEntity personEntity = new PersonEntity();
        personEntity.setId(person.getId());
        personEntity.setLogin(person.getLogin());
        personEntity.setPassword(person.getPassword());
        personEntity.setRole(person.getRole());
        personEntity.setPersonDetails(new PersonDetails());
        return personEntity;
    }

    public static Person fromEntity(PersonEntity personEntity) {
        if (personEntity == null) {
            return null;
        }
        return new Person(personEntity.getId(), personEntity.getLogin(), personEntity.getPassword(), personEntity.getRole());

        }
    }
