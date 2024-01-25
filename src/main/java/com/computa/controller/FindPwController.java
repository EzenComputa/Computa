// package com.computa.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.computa.entity.User;

// import com.computa.service.FindPwService;
// import com.computa.service.UserService;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;



// @Controller
// public class FindPwController {

//     private UserService userService;
    
//     public FindPwController(FindPwService findPwService, UserService userService){
//         this.findPwService=findPwService;
//         this.userService=userService;
//     }

//     @GetMapping("/findpw")
//     public String getFindPw (Model model, @RequestParam Str ) {
//         // PostMappig된 id와 ssid를 담을 곳이 필요

//         //Userservice에 있는 username, ssid 정보
//         User usernameinfo = userService.findUserByUsername(username);
//         User userssidinfo = userService.findUserBySsid(ssid); 

//         //UserTable의 id와 ssid 비교 
//         if(checkusername == usernameinfo)

//         return "/show_pw";
//     }

//     @PostMapping("/findpw/btn")
//     public String postFindPw(String username,String userSsid) {
//         // User user =userService.findUserByUsername(user.getId());
//         // 입력받을 매개변수가 필요함

//         // findPwService.addFindPW(userId, userSsid);

//         // 매개변수로 받은 userid와 userssid(postFindPw)를 받아
//         // userService의 Username을 찾음
//         User checkusername = userService.findUserByUsername(username);
//         User checkuserssid = userService.findUserBySsid(userSsid);


//         return "redirect:/findpw";
//     }
    
    
// }
