package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.pcparts.Hdd;
import com.app.entity.pcparts.Product;
import com.app.persistence.pcparts.HddRepository;
import com.app.persistence.pcparts.ProductRepository;
import com.app.service.HddService;
import com.app.service.UserService;


@Controller
public class HddController {
    private UserService userService;
    private final HddRepository hddRepository;
    private final HddService hddService;
    private final ProductRepository productRepository;

    @Autowired
    public HddController(HddRepository hddRepository, HddService hddService
                        , UserService userService, ProductRepository productRepository){
        this.hddRepository = hddRepository;
        this.hddService = hddService;
        this.userService = userService;
        this.productRepository = productRepository;
    }

    @PostMapping("/product/hddUp/submit")
    public String insertHdd(Model model, Hdd hdd) throws IOException{
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);

        hddRepository.save(hdd);
        hddService.insertHdd(hdd);
        return "product_list";
    }
    
    
}
