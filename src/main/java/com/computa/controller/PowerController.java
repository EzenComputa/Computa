package com.computa.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.computa.entity.pcparts.Power;
import com.computa.persistence.pcparts.PowerRepository;
import com.computa.service.PowerService;
import com.computa.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class PowerController {
    private UserService userService;
    private final PowerRepository powerRepository;
    private final PowerService powerService;

    @Autowired
    public PowerController(PowerRepository powerRepository, PowerService powerService, UserService userService){
        this.powerRepository = powerRepository;
        this.powerService = powerService;
        this.userService = userService;
    }

    @PostMapping("/product/powerUp/submit")
    public String insertPower(Model model, Power power) throws IOException{
        powerRepository.save(power);
        powerService.insertPower(power);
        return "product_list";
    }
    
    
}
