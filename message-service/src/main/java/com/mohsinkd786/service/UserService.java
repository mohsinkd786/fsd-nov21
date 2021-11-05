package com.mohsinkd786.service;

import com.mohsinkd786.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Value("# {'${external.api.hello-world}'}")
    private String url;

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto saveUser(UserDto userDto){
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type","application/json");

        HttpEntity<UserDto> request = new HttpEntity<>(userDto,headers);

        //ResponseEntity<UserDto> responseEntity = restTemplate.postForEntity(url,request,UserDto.class);
        ResponseEntity<UserDto> responseEntity = restTemplate.exchange(url,HttpMethod.POST,request,UserDto.class);
        return responseEntity.getBody();
    }
}

/*
*  message-service = endpoints ( )
*       uses spring-hello-world (http://localhost:8111/users /POST)
*
*
*
* Problem 1: Assume we have two micro services -
*               service-1  - user info,
*               service-2 , - project info
*
* service-3:
*   Build an application to give me Project account details such as : Project budget & cost investments, user salaries &
*       their peers such as A is the manager of B so B reports to A or A has two sub ordinates : B & C
*
*
*
*
* */
