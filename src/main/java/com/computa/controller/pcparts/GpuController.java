package com.computa.controller.pcparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.computa.service.pcparts.GpuService;

@Controller
public class GpuController {

    @Autowired
    private GpuService gpuService;

    @GetMapping("/gpus")
    public String listGpus(Model model) {
        model.addAttribute("products", gpuService.findAll());
        model.addAttribute("productType", "GPU");
        return "product_list";
    }
}