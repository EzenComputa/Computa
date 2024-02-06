package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.pcparts.PcPower;
import com.app.persistence.pcparts.PcPowerRepository;
import com.app.service.PcPowerService;
import com.app.service.UserService;


@Controller
public class PcPowerController {
    private UserService userService;
    private final PcPowerRepository pcpowerRepository;
    private final PcPowerService pcPowerService;

    @Autowired
    public PcPowerController(PcPowerRepository pcpowerRepository, PcPowerService pcpowerService, UserService userService){
        this.pcpowerRepository = pcpowerRepository;
        this.pcPowerService = pcpowerService;
        this.userService = userService;
    }

    @PostMapping("/product/pcpowerUp/submit")
    public String insertPcPower(Model model, PcPower pcpower) throws IOException{
        pcpowerRepository.save(pcpower);
        pcPowerService.insertPcPower(pcpower);
        return "product_list";
    }
    
    
}
