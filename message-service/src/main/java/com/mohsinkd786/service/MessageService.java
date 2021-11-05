package com.mohsinkd786.service;

import com.mohsinkd786.dto.ProjectUser;
import com.mohsinkd786.service.amqp.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessagePublisher publisher;
    @Autowired
    public void setPublisher(MessagePublisher publisher) {
        this.publisher = publisher;
    }

    public void sendMessagetoQueue(ProjectUser user){
        publisher.sendMessage(user);
    }
}
