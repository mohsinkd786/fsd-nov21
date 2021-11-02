package com.mohsinkd786.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String projectId = UUID.randomUUID().toString();
    private String name;
    private double budget;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<User> users;
}


/*
*  Relationships :
* 1. One to One
* 2. One to Many
* 3. Many to Many
* 4. Many to One
*
* */
