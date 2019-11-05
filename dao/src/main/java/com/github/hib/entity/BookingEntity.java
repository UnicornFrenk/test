package com.github.hib.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class BookingEntity {


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

    @ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<ItemEntity> itemList = new ArrayList<>();


    public BookingEntity(Integer user_Id, Integer item_id, Integer totalPrice, Address deliveryAddress) {
        this.user_Id = user_Id;
        this.item_id = item_id;
        this.totalPrice = totalPrice;
        this.deliveryAddress = deliveryAddress;
    }


    public List<ItemEntity> getItems() {
        return itemList;
    }

    public void setItems(List<ItemEntity> items) {
        this.itemList = items;
    }

    @Override
    public String toString() {
        return "BookingEntity{" + "id=" + id + ", user_Id=" + user_Id + ", item_id=" + item_id + ", totalPrice=" + totalPrice + ", deliveryAddress=" + deliveryAddress + '}';
    }
}
