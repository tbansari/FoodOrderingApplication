package com.foodOrder.momos.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.util.Date;

@Entity
@Table(name = "dishesTbl")
@Where(clause="is_deleted=0")
@Data
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="dishId")
    private long id;

    @Column(name="dishName", unique = true)
    private String dishName;

    @Column(name="dishType")
    private String dishType;

    @Column(name="amount")
    private long amount;

    @CreationTimestamp
    @Column(name="createdOn")
    private Date createdOn;

    @UpdateTimestamp
    @Column(name="updatedOn")
    private Date updatedOn;

    @Column(name="isDeleted")
    private Boolean isDeleted;
}
