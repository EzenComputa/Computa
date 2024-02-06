package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.pcparts.Motherboard;
import com.app.persistence.pcparts.MotherboardRepository;
import com.app.service.MotherboardService;
import com.app.service.UserService;


@Controller
public class MotherboardController {
    private UserService userService;
    private final MotherboardRepository motherboardRepository;
    private final MotherboardService motherboardService;

    @Autowired
    public MotherboardController(MotherboardRepository motherboardRepository, MotherboardService motherboardService, UserService userService){
        this.motherboardRepository = motherboardRepository;
        this.motherboardService = motherboardService;
        this.userService = userService;
    }

    @PostMapping("/product/motherboardUp/submit")
    public String insertMotherboard(Model model, Motherboard motherboard) throws IOException{
        motherboardRepository.save(motherboard);
        motherboardService.insertMotherboard(motherboard);
        return "product_list";
    }
    
    
}
