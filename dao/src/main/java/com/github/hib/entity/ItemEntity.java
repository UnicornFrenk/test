package com.github.hib.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Item", unique = true)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name ="description" )
    private String description;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Integer price;


    public ItemEntity(String name, String description, Integer quantity, Integer price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;

    }

    @ManyToOne
    @JoinColumn(name = "categoryId", insertable=false, updatable=false)
    private CategoryEntity category;

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "item_booking", joinColumns = {@JoinColumn(name = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "id")}
//    )
//    private List<OrderEntity> orders = new ArrayList<>();
//
//    public List<OrderEntity> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<OrderEntity> orders) {
//        this.orders = orders;
//    }


}
