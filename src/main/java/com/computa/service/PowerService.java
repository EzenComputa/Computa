package com.computa.service;

import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Power;

@Service
public interface PowerService {

    void insertPower(Power power);
    
}