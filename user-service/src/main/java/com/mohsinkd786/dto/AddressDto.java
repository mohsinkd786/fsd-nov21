package com.mohsinkd786.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String id;
    private String street;
    private String city;
    private int zipCode;
}
