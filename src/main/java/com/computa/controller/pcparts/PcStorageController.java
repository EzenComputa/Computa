package com.computa.controller.pcparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.computa.service.pcparts.PcStorageService;

@Controller
public class PcStorageController {
    
    @Autowired
    private PcStorageService pcStorageService;

    @GetMapping("/product/storage")
    public String listPcStorages(Model model) {
    model.addAttribute("products", pcStorageService.getAllPcStorage());
    model.addAttribute("productType", "Storage");
    return "product_list";
}
}
