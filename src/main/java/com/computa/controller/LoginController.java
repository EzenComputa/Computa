package com.computa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.computa.domain.User;
import com.computa.service.UserService;

@Controller
@SessionAttributes("user")
public class LoginController {
    
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
	public String loginView() {
		return "login";
	}

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.getUserById(username);
        if (user != null && password.equals(user.getPassword())) {
            model.addAttribute("user", user);
            return "redirect:/index";
        } else {
            return "Invalid username or password";
        }
    }
}
