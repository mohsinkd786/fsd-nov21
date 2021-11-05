package com.mohsinkd786.repository.mongo;

import com.mohsinkd786.entity.mongo.EmployeeDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<EmployeeDto,String> {

    List<EmployeeDto> findByContact_DialCode(String dialCode);

    //List<EmployeeDto> findByLocation_Address();
}


/*
* user-service:
* 1. make a rest call , using resttemplate
*
* message-service:
*
* Rabbit Mq - Messaging Queue
*
* Broker :
* queue : 1 to 1 messages
* topic : many to many messages or 1 to many
*
* AMQP - Advanced Message Queue Protocol.
* Producer -
*           RabbitMQ Broker (Exchange)-> will send messages to Queue
*    Consumer - always consumes messages from the queue
* */
