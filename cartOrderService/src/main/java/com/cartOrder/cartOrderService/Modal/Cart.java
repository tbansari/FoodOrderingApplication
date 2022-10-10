package com.cartOrder.cartOrderService.Modal;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cartTbl")
@Where(clause="is_deleted=0")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cartId")
    private long id;

    @Column(name="userId")
    private long userId;

    @Column(name="dishId")
    private long dishId;

    @Column(name="quantity")
    private int quantity;

    @CreationTimestamp
    @Column(name="createdOn")
    private Date createdOn;

    @UpdateTimestamp
    @Column(name="updatedOn")
    private Date updatedOn;

    @Column(name="isDeleted")
    private Boolean isDeleted;

}
