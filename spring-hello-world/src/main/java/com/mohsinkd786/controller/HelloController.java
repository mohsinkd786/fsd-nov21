package com.mohsinkd786.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("sayHello")
    public String sayHello(){
        return "Hello Spring!";
    }

    @GetMapping("/message/{msg}")
    public String getMessage(@PathVariable String msg){
        return "Welcome to : "+msg;
    }

    @GetMapping("/calculate/add")
    public double add(@RequestParam(defaultValue = "0") Integer i, @RequestParam(defaultValue = "0") Integer j){
        return i + j;
    }
}

/*
* Pass Data in URL :
* 1. Path Param : /1/Mohsin
* 2. Query Param : ?id=1&name=Mohsin
*
* */
