package com.app.service;

import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Motherboard;

@Service
public interface MotherboardService {

    void insertMotherboard(Motherboard motherboard);
    
}