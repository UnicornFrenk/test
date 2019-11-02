package com.github.model;

import com.github.hib.entity.Address;


public class Order {
    private Integer id;
    private Integer user_Id;
    private Integer item_id;
    private Integer totalPrice;
    private Address deliveryAddress;

    public Order() {
    }

    public Order(Integer id, Integer user_Id, Integer item_id, Integer totalPrice, Address deliveryAddress) {
        this.id = id;
        this.user_Id = user_Id;
        this.item_id = item_id;
        this.totalPrice = totalPrice;
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user_Id=" + user_Id + ", item_id=" + item_id + ", totalPrice=" + totalPrice + ", deliveryAddress=" + deliveryAddress + '}';
    }
}
