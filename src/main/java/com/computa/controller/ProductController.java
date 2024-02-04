package com.computa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {

    @GetMapping("/product/list")
    public String getPrdlistPage() {
        return "product_list";
    }
    
    @GetMapping("/product/Detail")
    public String getPrdPage() {
        return "prod_detail";
    }

    @GetMapping("/product/up")
    public String getPrdupPage() {
        return "prod_up";
    }

    @GetMapping("/product/cpu")
    public String getCpu() {
        return "prod_up_cpu";
    }
    @GetMapping("/product/gpu")
    public String getGpu() {
        return "prod_up_gpu";
    }
    @GetMapping("/product/motherboard")
    public String getMb() {
        return "prod_up_motherboard";
    }
    @GetMapping("/product/hdd")
    public String getHdd() {
        return "prod_up_cpu";
    }
    @GetMapping("/product/ssd")
    public String getSsd() {
        return "prod_up_ssd";
    }
    @GetMapping("/product/power")
    public String getPower() {
        return "prod_up_power";
    }
    @GetMapping("/product/case")
    public String getCase() {
        return "prod_up_case";
    }
    @GetMapping("/product/cooler")
    public String getCooler() {
        return "prod_up_cooler";
    }
    @GetMapping("/product/ram")
    public String getRam() {
        return "prod_up_ram";
    }  
}
