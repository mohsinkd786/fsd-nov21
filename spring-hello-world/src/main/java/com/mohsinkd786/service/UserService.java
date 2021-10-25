package com.mohsinkd786.service;

import com.mohsinkd786.dto.UserDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Component
//@Scope("prototype")
@Service
public class UserService {

    private List<UserDto> userDtos = new ArrayList<>();

    public UserDto createUser(UserDto userDto){
        userDtos.add(userDto);
        return userDto;
    }

    public void deleteUser(String userId){
        userDtos = userDtos
                .stream()
                .filter(u-> !u.getId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<UserDto> getUsers(){
        return userDtos;
    }
}
