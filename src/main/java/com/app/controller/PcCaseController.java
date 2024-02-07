package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.pcparts.PcCase;
import com.app.persistence.pcparts.PcCaseRepository;
import com.app.service.PcCaseService;
import com.app.service.UserService;


@Controller
public class PcCaseController {
    private UserService userService;
    private final PcCaseRepository pcCaseRepository;
    private final PcCaseService pcCaseService;

    @Autowired
    public PcCaseController(PcCaseRepository pcCaseRepository, PcCaseService pcCaseService, UserService userService){
        this.pcCaseRepository = pcCaseRepository;
        this.pcCaseService = pcCaseService;
        this.userService = userService;
    }

    @PostMapping("/product/pcCaseUp/submit")
    public String insertPcCase(Model model, PcCase pcCase) throws IOException{
        pcCaseRepository.save(pcCase);
        pcCaseService.insertPcCase(pcCase);
        return "product_list";
    }
    
    
}
