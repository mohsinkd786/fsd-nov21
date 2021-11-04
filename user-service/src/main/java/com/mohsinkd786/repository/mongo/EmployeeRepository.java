package com.mohsinkd786.repository.mongo;

import com.mohsinkd786.entity.mongo.EmployeeDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeDto,String> {
}
