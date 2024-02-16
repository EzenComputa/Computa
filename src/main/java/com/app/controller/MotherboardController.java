package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.pcparts.Motherboard;
import com.app.entity.pcparts.Product;
import com.app.persistence.pcparts.MotherboardRepository;
import com.app.persistence.pcparts.ProductRepository;
import com.app.service.MotherboardService;
import com.app.service.UserService;


@Controller
public class MotherboardController {
    private UserService userService;
    private final MotherboardRepository motherboardRepository;
    private final MotherboardService motherboardService;
    private final ProductRepository productRepository;

    @Autowired
    public MotherboardController(MotherboardRepository motherboardRepository, MotherboardService motherboardService
                            , UserService userService, ProductRepository productRepository){
        this.motherboardRepository = motherboardRepository;
        this.motherboardService = motherboardService;
        this.userService = userService;
        this.productRepository = productRepository;
    }

    @PostMapping("/product/motherboardUp/submit")
    public String insertMotherboard(Model model, Motherboard motherboard) throws IOException{
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);

        motherboardRepository.save(motherboard);
        motherboardService.insertMotherboard(motherboard);
        return "product_list";
    }
    
    
}
