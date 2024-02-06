package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.pcparts.Cpu;
import com.app.persistence.pcparts.CpuRepository;
import com.app.service.CpuService;
import com.app.service.UserService;


@Controller
public class CpuController {
    private UserService userService;
    private final CpuRepository cpuRepository;
    private final CpuService cpuService;

    @Autowired
    public CpuController(CpuRepository cpuRepository, CpuService cpuService, UserService userService){
        this.cpuRepository = cpuRepository;
        this.cpuService = cpuService;
        this.userService = userService;
    }

    @PostMapping("/product/cpuUp/submit")
    public String insertCpu(Model model, Cpu cpu) throws IOException{
        cpuRepository.save(cpu);
        cpuService.insertCpu(cpu);
        return "product_list";
    }
    
    
}
