package com.learn.customerdata.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="email")
    private String email;
}
