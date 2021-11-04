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

/*
* Big Data:
*
* 1. Velocity : Rate
* 2. Veracity : Reliability
* 3. Volume : Quantity
* 4. Variety : Versatility
* 5. Value : Level of Criticality
*
* SQL -> No SQL
* Schema Less
* CAP Theorm:
* 1. Consistency :
* 2. Availability
* 3. Partition
*
* Types of NoSql's
* 1. Document Based: MongoDb
* 2. Column Based: Cassandra
* 3. Key value Based: Redis
* 4. Graph Based: Neo4J
* 5. Time Series Based: Influx
*
*
*  { "id": 1,"name":"Mohsin"}
*
* Database : Tables : Row - group of columns
* Mongo:
*   Database:
*       Collections:
*           Group of Documents:
*                   Group of Fields
*
* select * from users; db.users.find();
*  users : [id,name,_id]
* select name from users; db.users.find({},{name:1,_id:0});
* users: [name]             users: [name]
* */
