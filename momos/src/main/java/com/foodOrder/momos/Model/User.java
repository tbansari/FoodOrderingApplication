package com.foodOrder.momos.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.util.Date;

@Entity
@Table(name = "userTbl")
@Where(clause="is_deleted=0")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userId")
    private long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="phone", unique = true)
    private String phone;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="address")
    private String address;

    @CreationTimestamp
    @Column(name="createdOn")
    private Date createdOn;

    @UpdateTimestamp
    @Column(name="updatedOn")
    private Date updatedOn;

    @Column(name="isDeleted")
    private Boolean isDeleted;

}
