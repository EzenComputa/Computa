package com.computa.controller.pcparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.computa.service.pcparts.PcCaseService;

@Controller
public class PcCaseController {
    
    @Autowired
    private PcCaseService pcCaseService;

    @GetMapping("/product/case")
    public String listPcCases(Model model) {
        model.addAttribute("products", pcCaseService.getAllPcCases());
        model.addAttribute("productType", "Case");
        return "product_list";
    }
    
}
