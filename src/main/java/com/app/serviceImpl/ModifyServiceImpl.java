package com.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.persistence.ModifyRepository;
import com.app.persistence.UserRepository;
import com.app.service.ModifyService;

@Service
public class ModifyServiceImpl implements ModifyService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ModifyRepository modifyRepository; 

    @Autowired
    public ModifyServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                        ModifyRepository modifyRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modifyRepository = modifyRepository;
    }

    public void userModify(
        String username, String newNickname, String newPassword,
        String newName, String newEmail){

    User user = userRepository.findByUsername(username);

    if(user != null){
        if(newNickname != null && !newNickname.isEmpty()){
            user.setNickname(newNickname);
        }
        if(newPassword != null && !newPassword.isEmpty()){
            user.setPassword(passwordEncoder.encode(newPassword));
        }
        if(newName != null && !newName.isEmpty()){
            user.setName(newName);
        }
        if(newEmail != null && !newEmail.isEmpty()){
            user.setEmail(newEmail);
        }
        userRepository.save(user);
    }
}


    public void userDelete(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.getRoles().clear();
            userRepository.delete(user);
        }
    }
}