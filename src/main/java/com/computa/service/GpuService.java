package com.computa.service;

import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Gpu;

@Service
public interface GpuService {

    void insertGpu(Gpu gpu);
    
}