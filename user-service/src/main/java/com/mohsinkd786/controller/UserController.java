package com.mohsinkd786.controller;

import com.mohsinkd786.dto.UserDto;
import com.mohsinkd786.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> findUsers(){
        return userService.findUsers();
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDto userDto){
        return new ResponseEntity(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable("id") String userId){
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/id/{id}")
    public UserDto findUserById(@PathVariable("id") String userId){
        return userService.findUserById(userId);
    }
    @GetMapping("/email/{email}")
    public UserDto findUserByEmail(@PathVariable("email") String email){
        return userService.findUserByEmail(email);
    }
}
