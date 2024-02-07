package com.app.service;

import java.util.List;

import com.app.dto.UserDto;
import com.app.entity.User;

public interface UserService {
    
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    User findUserByUsername(String username);


    List<UserDto> findAllUsers();
}