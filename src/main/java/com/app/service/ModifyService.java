package com.app.service;

import org.springframework.stereotype.Service;

@Service
public interface ModifyService {
    void userDelete(String username);  
    void userModify(String username, String newNickname, String newPassword, String newName, String newEmail); 
}