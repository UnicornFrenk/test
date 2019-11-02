package com.github.hib.entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("goodUSer")
public class GoodUser extends PersonEntity {
}
