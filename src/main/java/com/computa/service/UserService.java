package com.computa.service;

import java.util.List;

import com.computa.domain.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id);
    void saveUser(User user);
    User getUserByEmail(String email);
    User getUserBySsid(String ssid);
}