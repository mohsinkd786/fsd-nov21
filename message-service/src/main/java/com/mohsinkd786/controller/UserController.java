package com.mohsinkd786.controller;

import com.mohsinkd786.dto.ProjectUser;
import com.mohsinkd786.dto.UserDto;
import com.mohsinkd786.service.MessageService;
import com.mohsinkd786.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;
    private MessageService messageService;

    @Autowired
    public UserController(UserService service){
        userService = service;
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @PostMapping("/user/sendMessage")
    public ResponseEntity sendMessage(@RequestBody ProjectUser user){
        messageService.sendMessagetoQueue(user);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
