package com.computa.controller.pcparts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.computa.entity.ProductComment;
import com.computa.entity.pcparts.Cooler;
import com.computa.entity.pcparts.Cpu;
import com.computa.entity.pcparts.Gpu;
import com.computa.entity.pcparts.Motherboard;
import com.computa.entity.pcparts.PcCase;
import com.computa.entity.pcparts.PcStorage;
import com.computa.entity.pcparts.Product;
import com.computa.entity.pcparts.Psu;
import com.computa.entity.pcparts.Ram;
import com.computa.exceptions.ResourceNotFoundException;
import com.computa.persistence.pcparts.ProductRepository;
import com.computa.service.ProductCommentService;
import com.computa.service.UserService;
import com.computa.service.pcparts.ProductService;

import jakarta.annotation.PostConstruct;

@Controller
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCommentService productCommentService;

    @Autowired
    private UserService userService;

    @Autowired
    private Map<String, ProductService> productServiceMap;

    @GetMapping("/product")
    public String showProductList(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product_list";
    }

    @GetMapping("/product_details")
    public String showProductDetails(@RequestParam("id") Long id, Model model) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        List<ProductComment> productComments = productCommentService.getProductCommentsByProductId(id);
        model.addAttribute("product", product);
        model.addAttribute("productType", product.getProductType());
        model.addAttribute("comments", productComments);
        return "product_details";
    }

    // The variable name, such as 'parentId' for @RequestParam must match the name of the input field in the form. 
    @PostMapping("/saveProductComment")
    public String saveProductComment(@RequestParam String content,
                                    @RequestParam Long productId,
                                    @RequestParam(required = false) Long parentId,
                                    @AuthenticationPrincipal UserDetails currentUser) {
        Long userId = userService.findUserByUsername(currentUser.getUsername()).getId();                             
        productCommentService.saveProductComment(productId, userId, parentId, content);
        return "redirect:/product_details";
    }

    @GetMapping("/product/add/{type}")
    public String addProduct(@PathVariable String type, Model model) {
        switch (type.toLowerCase()) {
            case "cooler":
                model.addAttribute("cooler", new Cooler());
                return "addProduct/addCooler";
            case "cpu":
                model.addAttribute("cpu", new Cpu());
                return "addProduct/addCpu";
            case "gpu":
                model.addAttribute("gpu", new Gpu());
                return "addProduct/addGpu";
            case "motherboard":
                model.addAttribute("motherboard", new Motherboard());
                return "addProduct/addMotherboard";
            case "case":
                model.addAttribute("pcCase", new PcCase());
                // return "addProduct/addPcCase";
                return "prod_up_case.html";
            case "storage":
                model.addAttribute("pcStorage", new PcStorage());
                return "addProduct/addPcStorage";
            case "psu":
                model.addAttribute("psu", new Psu());
                return "addProduct/addPsu";
            case "ram":
                model.addAttribute("ram", new Ram());
                return "addProduct/addRam";
            default:
                throw new IllegalArgumentException("Invalid product type: " + type);
        }

    }

    // The fact that I have to make a postMapping for every single product type is outrageous
    @PostMapping("/saveProduct/Cooler")
    public String saveCooler(@ModelAttribute Cooler cooler, RedirectAttributes redirectAttributes) {
        productServiceMap.get("coolerServiceImpl").save(cooler);
        redirectAttributes.addFlashAttribute("message", "Cooler added successfully");
        return "redirect:/addProduct/cooler";
    }

    @PostMapping("/saveProduct/Cpu")
    public String saveCpu(@ModelAttribute Cpu cpu, RedirectAttributes redirectAttributes) {
        productServiceMap.get("cpuServiceImpl").save(cpu);
        redirectAttributes.addFlashAttribute("message", "CPU added successfully");
        return "redirect:/addProduct/cpu";
    }

    @PostMapping("/saveProduct/Gpu")
    public String saveGpu(@ModelAttribute Gpu gpu, RedirectAttributes redirectAttributes) {
        productServiceMap.get("gpuServiceImpl").save(gpu);
        redirectAttributes.addFlashAttribute("message", "GPU added successfully");
        return "redirect:/addProduct/gpu";
    }

    @PostMapping("/saveProduct/Motherboard")
    public String saveMotherboard(@ModelAttribute Motherboard motherboard, RedirectAttributes redirectAttributes) {
        productServiceMap.get("motherboardServiceImpl").save(motherboard);
        redirectAttributes.addFlashAttribute("message", "Motherboard added successfully");
        return "redirect:/addProduct/motherboard";
    }

    @PostMapping("/saveProduct/PcCase")
    public String savePcCase(@ModelAttribute PcCase pcCase, RedirectAttributes redirectAttributes) {
        productServiceMap.get("pcCaseServiceImpl").save(pcCase);
        redirectAttributes.addFlashAttribute("message", "PC Case added successfully");
        return "redirect:/addProduct/pc_case";
    }

    @PostMapping("/saveProduct/PcStorage")
    public String savePcStorage(@ModelAttribute PcStorage pcStorage, RedirectAttributes redirectAttributes) {
        productServiceMap.get("pcStorageServiceImpl").save(pcStorage);
        redirectAttributes.addFlashAttribute("message", "PC Storage added successfully");
        return "redirect:/addProduct/pc_storage";
    }

    @PostMapping("/saveProduct/Psu")
    public String savePsu(@ModelAttribute Psu psu, RedirectAttributes redirectAttributes) {
        productServiceMap.get("psuServiceImpl").save(psu);
        redirectAttributes.addFlashAttribute("message", "PSU added successfully");
        return "redirect:/addProduct/psu";
    }

    @PostMapping("/saveProduct/Ram")
    public String saveRam(@ModelAttribute Ram ram, RedirectAttributes redirectAttributes) {
        productServiceMap.get("ramServiceImpl").save(ram);
        redirectAttributes.addFlashAttribute("message", "RAM added successfully");
        return "redirect:/addProduct/ram";
    }

    

}
