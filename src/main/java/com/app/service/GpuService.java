package com.app.service;

import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Gpu;

@Service
public interface GpuService {

    void insertGpu(Gpu gpu);
    
}