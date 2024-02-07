package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;

@Service
public interface FindPwService {
    String userCheck(String username);
    void updateUserPassword(String username, String newPassword);
}