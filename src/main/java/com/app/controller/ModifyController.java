package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entity.User;
import com.app.persistence.ModifyRepository;
import com.app.persistence.UserRepository;
import com.app.service.ModifyService;
import com.app.service.UserService;

@Controller
public class ModifyController {

    private ModifyService modifyService;
    private UserRepository userRepository;
    public ModifyRepository modifyRepository;
    public UserService userService;

    public ModifyController(ModifyService modifyService, UserRepository userRepository,
            ModifyRepository modifyRepository, UserService userService) {
        this.modifyService = modifyService;
        this.userRepository = userRepository;
        this.modifyRepository = modifyRepository;
        this.userService = userService;
    }

    @GetMapping("/user/mymodify")
    public String getModifyPage() {
        return "my_modify";
    }
    
    @PostMapping("/user/modify")
    public String updateUser(
                    @AuthenticationPrincipal UserDetails currentUser,
                    @RequestParam("name") String name,
                    @RequestParam("nickname") String nickname,
                    @RequestParam("password") String password,
                    @RequestParam("email") String email){
        
        ModifyService ModifyService = modifyService;
        modifyService.userModify(currentUser.getUsername(), nickname, password, name, email);
        return "/index";
    }



    // 삭제
    @PostMapping("/user/delete")
    public String postDelete() {

        return "user_modify_delete1";
    }

    @PostMapping("/user/delete/yes")
    public String postYes(@AuthenticationPrincipal UserDetails currentUser) {
        modifyService.userDelete(currentUser.getUsername());
        return "user_modify_delete2";
    }

    @PostMapping("/user/delete/no")
    public String postNo() {
        return "redirect:/user/mymodify";
    }
}