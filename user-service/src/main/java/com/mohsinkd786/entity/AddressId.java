package com.mohsinkd786.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class AddressId implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String addressId;

//    public AddressId(int id, String addressId) {
//        this.id = id;
//        this.addressId = addressId;
//    }
}
