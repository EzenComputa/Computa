package com.computa.controller.pcparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.computa.service.pcparts.CoolerService;

@Controller
public class CoolerController {
    
    @Autowired
    private CoolerService coolerService;

    @GetMapping("/product/cooler")
    public String listCoolers(Model model) {
        model.addAttribute("products", coolerService.getAllCooler());
        model.addAttribute("productType", "Cooler");
        return "product_list";
    }
}
