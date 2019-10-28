//package com.github.hib.pojo;
//
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column
//    private String login;
//
//    @Column
//    private String password;
//
//    @Column
//    private String role;
//
//    public User() {
//
//    }
//
//    public User(String login, String password, String role) {
//        this.login = login;
//        this.password = password;
//        this.role = role;
//    }
//    public User(Integer id, String login, String password, String role) {
//        this.id = id;
//        this.login = login;
//        this.password = password;
//        this.role = role;
//    }
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//        User user = (User) o;
//        return Objects.equals(getId(), user.getId()) && Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getRole(), user.getRole());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getLogin(), getPassword(), getRole());
//    }
//
//    @Override
//    public String toString() {
//        return "User{" + "id=" + id + ", login='" + login + '\'' + ", password='" + password + '\'' + ", role='" + role + '\'' + '}';
//    }
//}
