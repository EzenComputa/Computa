package com.computa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.computa.entity.ProductComment;
import com.computa.entity.pcparts.Product;
import com.computa.exceptions.ResourceNotFoundException;
import com.computa.persistence.pcparts.ProductRepository;
import com.computa.service.ProductCommentService;

@Controller
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCommentService productCommentService;

    @GetMapping("/product/details")
    public String showProductDetails(@RequestParam("id") Long id, Model model) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        List<ProductComment> productComments = productCommentService.getProductCommentsByProductId(id);
        model.addAttribute("product", product);
        model.addAttribute("productType", product.getProductType());
        model.addAttribute("comments", productComments);
        return "product_details";
    }

    @PostMapping("/saveProductComment")
public String saveProductComment(@RequestParam("content") String content,
                                 @RequestParam("productId") Long productId,
                                 @RequestParam("userId") Long userId,
                                 @RequestParam(value = "parentId", required = false) Long parentId,
                                 RedirectAttributes redirectAttributes) {
    ProductComment comment = new ProductComment();
    ProductComment savedComment = productCommentService.saveProductComment(comment, content, productId, userId, parentId);
    redirectAttributes.addAttribute("id", savedComment.getProduct().getId());
    return "redirect:/product/details";
}
}
