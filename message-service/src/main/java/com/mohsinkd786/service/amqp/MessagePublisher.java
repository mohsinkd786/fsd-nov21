package com.mohsinkd786.service.amqp;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohsinkd786.dto.ProjectUser;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${rabbitmq.queue}")
    private String queueName;
    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    public void sendMessage(ProjectUser user){
        ObjectMapper mapper = new ObjectMapper();
        try {
            // convert object to json string
            String message = mapper.writeValueAsString(user);
            rabbitTemplate.setRoutingKey(routingKey);
            rabbitTemplate.convertAndSend(queueName, message);
            System.out.println("Message has been published  " + message);
        }catch (JsonProcessingException ex){
            ex.printStackTrace();
        }
    }
}
