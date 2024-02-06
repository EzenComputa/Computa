package com.computa.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.computa.entity.pcparts.Ssd;
import com.computa.persistence.pcparts.SsdRepository;
import com.computa.service.SsdService;
import com.computa.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class SsdController {
    private UserService userService;
    private final SsdRepository ssdRepository;
    private final SsdService ssdService;

    @Autowired
    public SsdController(SsdRepository ssdRepository, SsdService ssdService, UserService userService){
        this.ssdRepository = ssdRepository;
        this.ssdService = ssdService;
        this.userService = userService;
    }

    @PostMapping("/product/ssdUp/submit")
    public String insertSsd(Model model, Ssd ssd) throws IOException{
        ssdRepository.save(ssd);
        ssdService.insertSsd(ssd);
        return "product_list";
    }
    
    
}
