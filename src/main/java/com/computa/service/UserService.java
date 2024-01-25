package com.computa.service;

import com.computa.dto.UserDto;
import com.computa.entity.User;

import java.util.List;

public interface UserService {
    
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    User findUserBySsid(String ssid);

    User findUserByUsername(String username);

    List<UserDto> findAllUsers();
}