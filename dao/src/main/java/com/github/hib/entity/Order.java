package com.github.hib.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user_Id;
    private Integer item_id;
    private Integer totalPrice;
    private String deliveryAddres;

    public Order() {
    }

    public Order(Integer user_Id, Integer item_id, Integer totalPrice, String deliveryAddres) {
        this.user_Id = user_Id;
        this.item_id = item_id;
        this.totalPrice = totalPrice;
        this.deliveryAddres = deliveryAddres;
    }

    public Order(Integer id, Integer user_Id, Integer item_id, Integer totalPrice) {
        this.id = id;
        this.user_Id = user_Id;
        this.item_id = item_id;
        this.totalPrice = totalPrice;
        this.deliveryAddres = deliveryAddres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column
    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }
    @Column
    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }
    @Column
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
    @Column
    public String getDeliveryAddres() {
        return deliveryAddres;
    }

    public void setDeliveryAddres(String deliveryAddres) {
        this.deliveryAddres = deliveryAddres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(user_Id, order.user_Id) && Objects.equals(item_id, order.item_id) && Objects.equals(totalPrice, order.totalPrice) && Objects.equals(deliveryAddres, order.deliveryAddres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_Id, item_id, totalPrice, deliveryAddres);
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user_Id=" + user_Id + ", item_id=" + item_id + ", totalPrice=" + totalPrice + ", deliveryAddres='" + deliveryAddres + '\'' + '}';
    }
}
