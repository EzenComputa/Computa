package com.app.service;

import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Cpu;

@Service
public interface CpuService {

    void insertCpu(Cpu cpu);
    
}