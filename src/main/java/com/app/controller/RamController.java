package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entity.User;
import com.app.entity.pcparts.Product;
import com.app.entity.pcparts.Ram;
import com.app.persistence.pcparts.ProductRepository;
import com.app.persistence.pcparts.RamRepository;
import com.app.service.RamService;
import com.app.service.UserService;



@Controller
public class RamController {
    private UserService userService;
    private final RamRepository ramRepository;
    private final RamService ramService;
    private final ProductRepository productRepository;


    @Autowired
    public RamController(RamRepository ramRepository, RamService ramService
                , UserService userService, ProductRepository productRepository){
        this.ramRepository = ramRepository;
        this.ramService = ramService;
        this.userService = userService;
        this.productRepository = productRepository;
    }

    
    // @GetMapping("/product/ram")
    // public String insertRamForm(Model model, Ram ram,
    //                              @AuthenticationPrincipal UserDetails currentUser) {
    //      if(currentUser == null){
    //     return "redirect:/login";
    // } else {
    //     User user = userService.findUserByUsername(currentUser.getUsername());
    //     model.addAttribute("user", user);
    //     return "prod_up_ram";
    //     }
    // }
    

    @PostMapping("/product/ramUp/submit")
    public String insertRam(Model model, Ram ram) throws IOException {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);

        // 데이터베이스에 저장
        ramRepository.save(ram);
        ramService.insertRam(ram);
        return "product_list";
    }
}
