package com.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entity.User;
import com.app.service.UserService;
import com.app.serviceImpl.UserServiceImpl;


@Controller
public class myMainController {

    private UserService userService;

    @Autowired
    public myMainController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/myMain")
    public String getmyMain(Model model, @AuthenticationPrincipal UserDetails currentUser) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUsername = authentication.getName(); // 현재 로그인한 유저네임을 가져옴
        User currentUserInfo = userService.findUserByUsername(currentUsername); // 현재 로그인한 사용자의 정보를 데이터베이스에서 찾아옴
        // 유저 정보를 가져와서 모델에 추가
        String currentNickname = currentUserInfo.getNickname(); // 현재 로그인한 사용자의 닉네임을 가져옴
        String currentName = currentUserInfo.getUsername(); // 현재 로그인한 사용자의 이름을 가져옴
        model.addAttribute("nickname", currentNickname);
        model.addAttribute("name", currentName);


        return "my_main";
    }

    @GetMapping("/likeProd")
    public String getlikeProd() {

        return "like_prod";
    }
 
    @GetMapping("/usedMyshop")
    public String getusedMyshop() {
        return "used_myshop";
    }

    @GetMapping("/myQnaList")
    public String getMethodName() {
        return "my_qna_list";
    }

    @GetMapping("/myTeabag")
    public String getMyteabag() {
        return "estimate";
    }
    
    
}
