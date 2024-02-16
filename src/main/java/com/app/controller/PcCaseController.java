package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.pcparts.PcCase;
import com.app.entity.pcparts.Product;
import com.app.persistence.pcparts.PcCaseRepository;
import com.app.persistence.pcparts.ProductRepository;
import com.app.service.PcCaseService;
import com.app.service.UserService;


@Controller
public class PcCaseController {
    private UserService userService;
    private final PcCaseRepository pcCaseRepository;
    private final PcCaseService pcCaseService;
    private final ProductRepository productRepository;

    @Autowired
    public PcCaseController(PcCaseRepository pcCaseRepository, PcCaseService pcCaseService
                        , UserService userService, ProductRepository productRepository){
        this.pcCaseRepository = pcCaseRepository;
        this.pcCaseService = pcCaseService;
        this.userService = userService;
        this.productRepository = productRepository;
    }

    @PostMapping("/product/pcCaseUp/submit")
    public String insertPcCase(Model model, PcCase pcCase) throws IOException{
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);

        pcCaseRepository.save(pcCase);
        pcCaseService.insertPcCase(pcCase);
        return "product_list";
    }
    
    
}
