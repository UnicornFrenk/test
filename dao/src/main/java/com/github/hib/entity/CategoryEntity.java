package com.github.hib.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private Integer idCategory;
    @Column(name = "name")
    private String nameCategory;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntity> items = new ArrayList<>();

    public CategoryEntity(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setEmployees(List<ItemEntity> items) {
        this.items = items;
    }
}
