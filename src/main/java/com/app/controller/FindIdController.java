package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.FindIdService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FindIdController {

    private FindIdService findidService;

    public FindIdController(FindIdService findIdService) {
        this.findidService = findIdService;

    }

    @GetMapping("/findid")
    public String getFindIdPage() {
        return "findid";
    }

    @PostMapping("/findid/submit") // findid.html line:62
    public String postFindID(@RequestParam("name") String name, Model model) { // findid.html line:62
        String ID = findidService.checkName(name);
        model.addAttribute("message", ID);
        return "find_user_id";
    }

}
