package com.mohsinkd786.service.amqp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohsinkd786.entity.mongo.EmployeeDto;
import com.mohsinkd786.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageListener {

    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void onMessage(String message){
        log.info("Message has been received "+message);
        // convert json string to Java Bean
        ObjectMapper mapper = new ObjectMapper();
        try{
            EmployeeDto employeeDto = mapper.readValue(message,EmployeeDto.class);
            userService.createEmployee(employeeDto);
        }catch (JsonProcessingException ex){
            ex.printStackTrace();
        }
    }
}
