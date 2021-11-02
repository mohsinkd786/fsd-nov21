package com.mohsinkd786.dto;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String name;
    private String email;
    private int phoneNumber;
    private AddressDto addressDto;
}
