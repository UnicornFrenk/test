package com.github.hib.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("blackListUser")
public class BlackListUser extends PersonEntity {
}
