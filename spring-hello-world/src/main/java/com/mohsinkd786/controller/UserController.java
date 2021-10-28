package com.mohsinkd786.controller;

import com.mohsinkd786.dto.UserDto;
import com.mohsinkd786.service.GithubService;
import com.mohsinkd786.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // to autowire via lombok required constructor
@RequestMapping("/users")
@RestController
public class UserController {


    // autowiring - by type , by name
    // via constructor / setter / variable injection
    //@Autowired
    private final UserService service;
    private final GithubService githubService;

//    @Autowired
//    public UserController(UserService userService){
//        this.service = userService;
//    }

    // in case of using setter injection
//    @Autowired
//    public void setService(UserService service) {
//        this.service = service;
//    }

    // CRUD operations on User
    //private List<UserDto> userDtos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        //userDtos.add(userDto);
        service.createUser(userDto);
        return  new ResponseEntity(userDto, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable("id") String userId){
//        userDtos = userDtos
//                .stream()
//                .filter(u-> !u.getId().equals(userId))
//                .collect(Collectors.toList());
        service.deleteUser(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public List<UserDto> getUsers(){
        //return userDtos;
        return service.getUsers();
    }

    @GetMapping("/github")
    public ResponseEntity<String> githubNameforUser(){
        return ResponseEntity.ok(githubService.getNameFromGithub());
    }
}
