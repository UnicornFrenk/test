package com.github.hib.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class DateEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @CreationTimestamp
    //@Column(name = "createOrderDate", updatable = false, insertable = true)
    private LocalDateTime createdDate;
    @UpdateTimestamp
    //@Column(insertable = false, updatable = true)
    private LocalDateTime updatedDate;
}
