// package com.computa.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.computa.entity.User;
// import com.computa.service.UserService;

// @Controller
// public class FindIdController {

//     private UserService userService;

//     public FindIdController(FindIdService findIdService, UserService userService) {
//         this.findIdService = findIdService;
//         this.userService = userService;
//     }

//     @GetMapping("/findId")
//     public String getFindId(Model model, @RequestParam String username, @RequestParam String ssid) {
//         // UserService에 있는 username, ssid 정보
//         User usernameInfo = userService.findUserByUsername(username);
//         User ssidInfo = userService.findUserBySsid(ssid);

//         // UserTable의 id와 ssid 비교 
//         if (usernameInfo != null && ssidInfo != null && usernameInfo.equals(ssidInfo)) {
//             // Add data to the model if needed
//             model.addAttribute("username", usernameInfo.getUsername());
//             model.addAttribute("ssid", ssidInfo.getSsid());

//             return "show_id"; // "show_id"가 올바른 뷰 이름인지 확인하세요.
//         } else {
//             // username 또는 ssid를 찾지 못한 경우 처리
//             return "error_page"; // 이에 대한 오류 페이지를 만들어 사용하세요.
//         }
//     }

//     @PostMapping("/findpw/btn")
//     public String postFindId(String username, String userSsid) {
//         // 매개변수로 받은 userid와 userssid(postFindPw)를 받아 userService의 Username을 찾음
//         User checkUsername = userService.findUserByUsername(username);
//         User checkUserSsid = userService.findUserBySsid(userSsid);

//         // 추가로 요구되는 로직을 기반으로 필요한 로직 추가 가능

//         return "redirect:/findid";
//     }
// }
