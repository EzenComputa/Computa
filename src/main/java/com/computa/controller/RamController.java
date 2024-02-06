package com.computa.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.computa.entity.User;
import com.computa.entity.pcparts.Product;
import com.computa.entity.pcparts.Ram;
import com.computa.persistence.pcparts.RamRepository;
import com.computa.service.ProductService;
import com.computa.service.RamService;
import com.computa.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class RamController {
    private UserService userService;
    private final RamRepository ramRepository;
    private final RamService ramService;
    private final Product product;

    @Autowired
    public RamController(RamRepository ramRepository, RamService ramService, UserService userService, Product product){
        this.ramRepository = ramRepository;
        this.ramService = ramService;
        this.userService = userService;
        this.product = product;

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
        // 데이터베이스에 저장
        ramRepository.save(ram);
        ramService.insertRam(ram);
        return "redirect:product/getRamDetail";
    }

    // @GetMapping("product/getRamDetail")
    // public String getRamDetail(Model model) {
    //     model.addAttribute("product", productService.getProductWithDetails(product.getId()));
    //     return "product_detail_ram";
    // }
    
}
