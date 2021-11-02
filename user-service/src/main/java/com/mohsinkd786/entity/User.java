package com.mohsinkd786.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id; // pk
    private String userId = UUID.randomUUID().toString();
    private String name;
    @Column(name = "email_address")
    private String email;
    private int phoneNumber; // column name : phone_number

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address; // One to One Relationship
}
