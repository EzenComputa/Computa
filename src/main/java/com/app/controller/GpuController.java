package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.pcparts.Gpu;
import com.app.entity.pcparts.Product;
import com.app.persistence.pcparts.GpuRepository;
import com.app.persistence.pcparts.ProductRepository;
import com.app.service.GpuService;
import com.app.service.UserService;


@Controller
public class GpuController {
    private UserService userService;
    private final GpuRepository gpuRepository;
    private final GpuService gpuService;
    private final ProductRepository productRepository;

    @Autowired
    public GpuController(GpuRepository gpuRepository, GpuService gpuService
                    , UserService userService, ProductRepository productRepository){
        this.gpuRepository = gpuRepository;
        this.gpuService = gpuService;
        this.userService = userService;
        this.productRepository = productRepository;
    }

    @PostMapping("/product/gpuUp/submit")
    public String insertGpu(Model model, Gpu gpu) throws IOException{
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);

        gpuRepository.save(gpu);
        gpuService.insertGpu(gpu);
        return "product_list";
    }
    
    
}
