package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.FindPwService;
import com.app.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class FindPwController {
    
    private UserService userService;
    private FindPwService findPwService;

    public FindPwController(FindPwService findPwService, UserService userService){
        this.userService = userService;
        this.findPwService = findPwService;
    }

    @GetMapping("/findpw")
    public String getFindpwPage() {
        return "find_pw";
    }

    @PostMapping("/findpw/btn")
    public String postFindpw (
                    @RequestParam ("username") String username,
                    HttpSession session,
                    Model model) {

        session.setAttribute("username", username);
    
        FindPwService FindPwService = findPwService;
        String link = FindPwService.userCheck(username);
        if(link == "pass"){
            return "find_pw_new1";
        }else{
            return "/index";
        }
    }   
    
    @PostMapping("/newpw/btn")
    public String postNewpw(
                    @RequestParam ("password") String password,
                    HttpSession session) {
        String username = (String) session.getAttribute("username");
     
        FindPwService FindPwService = findPwService;
        FindPwService.updateUserPassword(username, password);    
        return "find_pw_new2";
    }


    
    // String ssid = firstSsid+secondSsid;
    // model.addAttribute("message",ssid);
}
