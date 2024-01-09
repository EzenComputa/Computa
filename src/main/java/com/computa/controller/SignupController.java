package com.computa.controller;

import com.computa.Utility.UserValidator;
import com.computa.domain.User;
import com.computa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private final UserService userService;

    @Autowired
    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupView(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @Autowired
    private UserValidator userValidator;

    @PostMapping("/signup")
    public String signupUser(@ModelAttribute User user, BindingResult bindingResult) {
        // Validate the user's input
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            // If the input is not valid, re-display the signup form with error messages
            return "signup";
        }

        // If the input is valid, save the user and redirect to the login page
        userService.saveUser(user);
        return "redirect:/login";
    }
}