package com.computa.controller.pcparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.computa.service.pcparts.MotherboardService;

@Controller
public class MotherboardController {
    
    @Autowired
    private MotherboardService motherboardService;

    @GetMapping("/product/motherboard")
    public String listMotherboards(Model model) {
        model.addAttribute("products", motherboardService.getAllMotherboards());
        model.addAttribute("productType", "Motherboard");
        return "product_list";
    }

}
