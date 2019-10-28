package com.github.hib.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    private String nameCategory;

    public Category() {
    }

    public Category(Integer id, String nameCategory) {
        this.idCategory = id;
        this.nameCategory = nameCategory;
    }

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    @Column
    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(idCategory, category.idCategory) && Objects.equals(nameCategory, category.nameCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory, nameCategory);
    }

    @Override
    public String toString() {
        return "Category{" + "idCategory=" + idCategory + ", nameCategory='" + nameCategory + '\'' + '}';
    }
}
