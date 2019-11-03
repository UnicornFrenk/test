package com.github.hib.entity;


import com.github.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "id_Order")
    private Integer id;
    @Column
    private Integer user_Id;
    @Column
    private Integer item_id;
    @Column
    private Integer totalPrice;
    @Column
    private Address deliveryAddress;
//    @ManyToMany(mappedBy = "item", cascade = CascadeType.ALL)
//    private List<ItemEntity> itemList = new ArrayList<>();


    public OrderEntity(Integer user_Id, Integer item_id, Integer totalPrice, Address deliveryAddress) {
        this.user_Id = user_Id;
        this.item_id = item_id;
        this.totalPrice = totalPrice;
        this.deliveryAddress = deliveryAddress;
    }

//
//    public List<ItemEntity> getItems() {
//        return itemList;
//    }
//
//    public void setItems(List<ItemEntity> items) {
//        this.itemList = items;
//    }

}
