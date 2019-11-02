package com.github.hib.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//import java.util.ArrayList;
//import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class OrderEntity extends DateEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column
    private Integer user_Id;
    @Column
    private Integer item_id;
    @Column
    private Integer totalPrice;
    @Column
    private Address deliveryAddress;
//    @OneToMany(cascade = CascadeType.PERSIST)
//@ElementCollection(targetClass=Integer.class)
//    private List<PersonEntity> persons = new ArrayList<>(0);

//    @ManyToOne
//    @JoinColumn(name = "USER_ID")
//    private PersonEntity person;


    public OrderEntity(Integer user_Id, Integer item_id, Integer totalPrice, Address deliveryAddress) {
        this.user_Id = user_Id;
        this.item_id = item_id;
        this.totalPrice = totalPrice;
        this.deliveryAddress = deliveryAddress;
    }
//    public PersonEntity getPerson() {
//        return person;
//    }
//
//    public void setPerson(PersonEntity person) {
//        this.person = person;
//    }


}
