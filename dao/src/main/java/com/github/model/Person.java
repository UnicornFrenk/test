package com.github.model;

import com.github.hib.entity.Role;

import java.util.Objects;

public class Person {
    private Integer id;
    private String login;
    private String password;
    private Role role;

    public Person(){}

    public Person(Integer id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Person(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Person(String login, String password){
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person user = (Person) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role);
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", login='" + login + '\'' + ", password='" + password + '\'' + ", role=" + role + '}';
    }
}
