package com.mohsinkd786.service;

import com.mohsinkd786.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class UserService {

    @Value("${external.api.hello-world}")
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
