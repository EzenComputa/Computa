package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entity.pcparts.Product;
import com.app.persistence.pcparts.ProductRepository;
import com.app.service.ProductService;


@Controller
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;
    
    public ProductController(ProductRepository productRepository, ProductService productService){
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping("/product/list")
    public String getPrdlistPage(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);

        return "product_list";
    }


    // @PostMapping("/product/ramUp/submit")
    // public String getProdListPage(Model model) {
    //     List<Product> productList = productRepository.findAll();
    //     model.addAttribute("products", productList);

    //     return "product_list";
    // }
    
    @GetMapping("/product/Detail")
    public String getPrdPage(Model model, @RequestParam("productId") Long productId) {
        // productId를 사용하여 해당하는 제품 정보를 데이터베이스에서 가져온다고 가정
        Product product = productService.getProductById(productId);

        // 모델에 제품 정보를 추가하여 Tymeleaf에서 사용할 수 있도록 함
        model.addAttribute("product", product);

        return "product_detail";
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
