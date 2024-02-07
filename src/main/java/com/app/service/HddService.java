package com.app.service;

import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Hdd;

@Service
public interface HddService {

    void insertHdd(Hdd hdd);
    
}