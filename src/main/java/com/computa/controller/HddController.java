package com.computa.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.computa.entity.pcparts.Hdd;
import com.computa.persistence.pcparts.HddRepository;
import com.computa.service.HddService;
import com.computa.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HddController {
    private UserService userService;
    private final HddRepository hddRepository;
    private final HddService hddService;

    @Autowired
    public HddController(HddRepository hddRepository, HddService hddService, UserService userService){
        this.hddRepository = hddRepository;
        this.hddService = hddService;
        this.userService = userService;
    }

    @PostMapping("/product/hddUp/submit")
    public String insertHdd(Model model, Hdd hdd) throws IOException{
        hddRepository.save(hdd);
        hddService.insertHdd(hdd);
        return "product_list";
    }
    
    
}
