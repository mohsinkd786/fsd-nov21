package com.mohsinkd786.service;

import com.mohsinkd786.dto.UserDto;
import com.mohsinkd786.entity.Address;
import com.mohsinkd786.entity.User;
import com.mohsinkd786.entity.mongo.EmployeeDto;
import com.mohsinkd786.mapper.UserMapper;
import com.mohsinkd786.repository.AddressRepository;
import com.mohsinkd786.repository.UserRepository;
import com.mohsinkd786.repository.mongo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private final UserMapper userMapper;

    public List<UserDto> findUsers(){
        return userRepository
                .findAll()
                .stream()
                .map(u-> userMapper.map(u,UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto createUser(UserDto userDto){
        User entity = userMapper.map(userDto,User.class);
        User savedEntity = userRepository.save(entity);
        UserDto saved = userMapper.map(savedEntity,UserDto.class);
        return saved;
    }

    public void deleteUser(String userId){
        User entityFound = userRepository.findByUserId(userId);
        if(Objects.nonNull(entityFound)){
            userRepository.delete(entityFound);
        }
    }

    public UserDto findUserById(String userId){
        User user = userRepository.findByUserId(userId);
        UserDto userDto = userMapper.map(user,UserDto.class);
        return userDto;
    }

    public UserDto findUserByEmail(String email){
        User user = userRepository.fetchByEmailAddress(email);
        UserDto userDto = userMapper.map(user,UserDto.class);
        return userDto;
    }

    public List<EmployeeDto> findEmployees(){
        return employeeRepository.findAll();
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        return employeeRepository.save(employeeDto);
    }

    public EmployeeDto findEmployeeById(String id){
        Optional<EmployeeDto> optional = employeeRepository.findById(id);
        return optional.isPresent()?optional.get():null;
    }
    public void deleteEmployeeById(String id){
        EmployeeDto employeeFound = findEmployeeById(id);
        if(Objects.nonNull(employeeFound)){
            employeeRepository.delete(employeeFound);
        }
    }
}
