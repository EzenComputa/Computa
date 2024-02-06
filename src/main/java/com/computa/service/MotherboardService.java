package com.computa.service;

import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Motherboard;

@Service
public interface MotherboardService {

    void insertMotherboard(Motherboard motherboard);
    
}