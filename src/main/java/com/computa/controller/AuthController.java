package com.computa.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.computa.dto.UserDto;
import com.computa.entity.User;
import com.computa.service.UserService;

import jakarta.validation.Valid;

// SpringSecurity.java deals with authentication and authorization (aka. login, access control, and logout)

@Controller
public class AuthController {

    // Thanks to Spring's dependency injection, it automatically injects the UserServiceImpl bean .
    // You inject UserService via constructor or field innjection.
    // You annotate this with @Autowired, though it is not necessary since Spring 4.3 if the class only has one constructor
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle home page request
    @GetMapping({"/index", "/", ""})
    public String home(){
        return "index";
    }

    // model.addAttribute("user", user) is used to bind an empty UserDto object to the form. 
    // This is typically used to set initial values for the form fields. 
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // @Valid @ModelAttribute("user") UserDto userDto is the data from the registration form.
    // The @ModelAttribute annotation tells Spring to bind the form data to the UserDto object. 
    // The @Valid annotation tells Spring to validate this object based on the validation annotations in the UserDto class.
    // BindingResult result object will contain the results of the validation.
    // If there are any validation errors, they will be stored in BindingResult result.
    // Model model is the object used to pass attributes from the controller to the view. 
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByUsername(userDto.getUsername());

        if(existingUser != null && existingUser.getUsername() != null && !existingUser.getUsername().isEmpty()){
            result.rejectValue("username", null,
                    "There is already an account registered with the same username");
        }

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(existingUser != null && existingUser.getNickname() != null && !existingUser.getNickname().isEmpty()){
            result.rejectValue("nickname", null,
                    "There is already an account registered with the same nickname");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/manage_users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "user_management";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }    

    @GetMapping("/find_user")
    public String findUserView(){
        return "find_user";
    }

    @GetMapping("/profile")
    public String showProfile(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        if (currentUser == null ){
            return "redirect:/login";
        }
        User user = userService.findUserByUsername(currentUser.getUsername());
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/user/profile")
    public String showUserProfile(@RequestParam("username") String username, Model model) {
        User user = userService.findUserByUsername(username);
        model.addAttribute("user", user);
        return "profile";
    }
    

}