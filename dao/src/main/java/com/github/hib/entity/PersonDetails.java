package com.github.hib.entity;


import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personDetails")
@Getter
@Setter
public class PersonDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private PersonEntity person;

    public PersonDetails(String street, String city, String state, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "PersonDetails{" + "userId=" + userId + ", street='" + street + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", country='" + country + '\'';
    }
}
