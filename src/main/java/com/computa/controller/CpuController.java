package com.computa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.computa.entity.pcparts.Cpu;
import com.computa.service.pcparts.CpuService;

@Controller
public class CpuController {
    
    @Autowired
    private CpuService cpuService;

    @GetMapping("/cpus")
    public String listCpus(Model model) {
        model.addAttribute("products", cpuService.findAll());
        model.addAttribute("productType", "CPU");
        return "product_list";
    }
}
