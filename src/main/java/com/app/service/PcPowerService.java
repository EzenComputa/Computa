package com.app.service;

import org.springframework.stereotype.Service;

import com.app.entity.pcparts.PcPower;

@Service
public interface PcPowerService {

    void insertPcPower(PcPower pcpower);
    
}