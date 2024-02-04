package com.computa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class myMainController {
    @GetMapping("/myMain")
    public String getmyMain() {

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
