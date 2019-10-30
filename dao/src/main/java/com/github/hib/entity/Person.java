package com.github.hib.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSON")
public class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column
    private Role role;

    @OneToOne(mappedBy = "person", fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private  PersonDetails personDetails;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();


    public Person(Integer id, String login, String password, Role role, PersonDetails personDetails) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.personDetails = personDetails;
    }

    public Person(Integer id, String login, String password, Role role) {
        this(id, login, password, role, null);
    }

    public Person(String login, String password) {
        this(null, login, password, null, null);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public PersonDetails getPersonDetails(){
        return personDetails;
    }

    public void setPersonDetails(){
        this.personDetails = personDetails;
    }

}
