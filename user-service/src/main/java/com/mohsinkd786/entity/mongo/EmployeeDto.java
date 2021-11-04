package com.mohsinkd786.entity.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.UUID;

@Data
@Document(collection = "employees")
public class EmployeeDto {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String email;
    private double salary;
}
