package com.mohsinkd786.controller;

import com.mohsinkd786.entity.mongo.EmployeeDto;
import com.mohsinkd786.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/employees")
@RestController
public class EmployeeController {
    private final UserService userService;

    @GetMapping
    public List<EmployeeDto> findEmployees(){
        return userService.findEmployees();
    }

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity(userService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") String id){
        userService.deleteEmployeeById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/id/{id}")
    public EmployeeDto findEmpById(@PathVariable("id") String id){
        return userService.findEmployeeById(id);
    }
}
