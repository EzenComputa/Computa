package com.computa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.computa.entity.User;
import com.computa.persistence.UserRepository;
import com.computa.service.FindPwService;

@Service
public class FindPwServiceImpl implements FindPwService{

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public FindPwServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String userCheck(String username){
        User user = userRepository.findByUsername(username);
        if (user !=null){
            return "pass";
        }else{
            return null;
        }
    }

    @Override
    public void updateUserPassword(String username, String newPassword){
        User user = userRepository.findByUsername(username);

        if(user!=null){
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        }
    }
}
