package com.mohsinkd786.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    //
    private String id = UUID.randomUUID().toString();
    private String name;
    private float salary;

//    public String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public float getSalary() {
//        return salary;
//    }
//
//    public void setSalary(float salary) {
//        this.salary = salary;
//    }
}
