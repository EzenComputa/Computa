package com.computa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnaController {
    @GetMapping("/qna_list")
    public String qnalistMain(){

        return "qna_list";
    }
}
