package com.computa.service;

import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Cpu;

@Service
public interface CpuService {

    void insertCpu(Cpu cpu);
    
}