package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.pcparts.Gpu;
import com.app.persistence.pcparts.GpuRepository;
import com.app.service.GpuService;
import com.app.service.UserService;


@Controller
public class GpuController {
    private UserService userService;
    private final GpuRepository gpuRepository;
    private final GpuService gpuService;

    @Autowired
    public GpuController(GpuRepository gpuRepository, GpuService gpuService, UserService userService){
        this.gpuRepository = gpuRepository;
        this.gpuService = gpuService;
        this.userService = userService;
    }

    @PostMapping("/product/gpuUp/submit")
    public String insertGpu(Model model, Gpu gpu) throws IOException{
        gpuRepository.save(gpu);
        gpuService.insertGpu(gpu);
        return "product_list";
    }
    
    
}
