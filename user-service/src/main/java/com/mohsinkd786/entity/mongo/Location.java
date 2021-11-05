package com.mohsinkd786.entity.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.UUID;

@Document
@Data
public class Location {
    @Id
    private String id = UUID.randomUUID().toString();
    private String address;
}
