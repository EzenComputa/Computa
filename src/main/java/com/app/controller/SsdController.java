package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.pcparts.Product;
import com.app.entity.pcparts.Ssd;
import com.app.persistence.pcparts.ProductRepository;
import com.app.persistence.pcparts.SsdRepository;
import com.app.service.SsdService;
import com.app.service.UserService;


@Controller
public class SsdController {
    private UserService userService;
    private final SsdRepository ssdRepository;
    private final SsdService ssdService;
    private final ProductRepository productRepository;

    @Autowired
    public SsdController(SsdRepository ssdRepository, SsdService ssdService
                    , UserService userService, ProductRepository productRepository){
        this.ssdRepository = ssdRepository;
        this.ssdService = ssdService;
        this.userService = userService;
        this.productRepository = productRepository;
    }

    @PostMapping("/product/ssdUp/submit")
    public String insertSsd(Model model, Ssd ssd) throws IOException{
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);

        ssdRepository.save(ssd);
        ssdService.insertSsd(ssd);
        return "product_list";
    }
    
    
}