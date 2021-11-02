package com.mohsinkd786.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ProjectDto {
    private String id;
    private String name;
    private double budget;
    private Set<UserDto> users;
}
