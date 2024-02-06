package com.computa.service;

import com.computa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface FindPwService {
    String userCheck(String username);
    void updateUserPassword(String username, String newPassword);
}