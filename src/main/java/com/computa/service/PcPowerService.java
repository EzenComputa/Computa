package com.computa.service;

import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.PcPower;

@Service
public interface PcPowerService {

    void insertPcPower(PcPower pcpower);
    
}