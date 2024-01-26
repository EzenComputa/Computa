// package com.computa.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.computa.entity.User;

// import com.computa.service.FindPwService;
// import com.computa.service.UserService;

// import org.springframework.web.bind.annotation.RequestBody;



// @Controller
// public class FindPwController {

//     private UserService userService;
//     private final FindPwService findPwService;
    
//     public FindPwController(FindPwService findPwService, UserService userService){
//         this.userService=userService;
//         this.findPwService=findPwService;
//     }


//     @GetMapping("/find_pw")
//     public String getFindpw( 
//             @RequestParam("username") String username,
//             @RequestParam("ssid") String ssid) {
        
//         FindPwService FindPwService = findPwService;
//         String nickName = FindPwService.userCheck(username, ssid);
//         System.out.println("당신의 비밀번호는 " + nickName + " 입니다.");
//             return "find_pass";
//     }
    

//     @PostMapping("/find_pass/find_pw")
//     public String postFindPw(
//             @RequestParam("username") String username,
//             @RequestParam("ssid") String ssid) {
        
//         FindPwService FindPwService = findPwService;

//         return "redirect:/find_pw";
//         }
    
// }
