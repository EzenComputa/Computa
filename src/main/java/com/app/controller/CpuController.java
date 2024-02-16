package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.pcparts.Cpu;
import com.app.entity.pcparts.Product;
import com.app.persistence.pcparts.CpuRepository;
import com.app.persistence.pcparts.ProductRepository;
import com.app.service.CpuService;
import com.app.service.UserService;


@Controller
public class CpuController {
    private UserService userService;
    private final CpuRepository cpuRepository;
    private final CpuService cpuService;
    private final ProductRepository productRepository;

    @Autowired
    public CpuController(CpuRepository cpuRepository, CpuService cpuService
                    , UserService userService, ProductRepository productRepository){
        this.cpuRepository = cpuRepository;
        this.cpuService = cpuService;
        this.userService = userService;
        this.productRepository = productRepository;
    }

    @PostMapping("/product/cpuUp/submit")
    public String insertCpu(Model model, Cpu cpu) throws IOException{
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);

        cpuRepository.save(cpu);
        cpuService.insertCpu(cpu);
        return "product_list";
    }
    
    
}
