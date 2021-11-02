package com.mohsinkd786.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String addressId = UUID.randomUUID().toString();
    private String street;
    private String city;
    private int zipCode;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_user_id")
//    private User user;
}
