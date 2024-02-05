package com.computa.controller.pcparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.computa.service.pcparts.PsuService;

@Controller
public class PsuController {
    
    @Autowired
    private PsuService psuService;

    @GetMapping("/product/psu")
    public String listPsus(Model model) {
        model.addAttribute("products", psuService.getAllPsu());
        model.addAttribute("productType", "PSU");
        return "product_list";
    }
}
