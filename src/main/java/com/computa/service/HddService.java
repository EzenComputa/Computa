package com.computa.service;

import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Hdd;

@Service
public interface HddService {

    void insertHdd(Hdd hdd);
    
}