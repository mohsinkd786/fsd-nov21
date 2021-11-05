package com.mohsinkd786.entity.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.UUID;

@Document
@Data
public class Contact {
    @Id
    private String id = UUID.randomUUID().toString();
    private String phoneNumber;
    private String dialCode;
}
