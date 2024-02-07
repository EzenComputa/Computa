package com.app.service;

import org.springframework.stereotype.Service;

import com.app.entity.pcparts.PcCase;

@Service
public interface PcCaseService {

    void insertPcCase(PcCase pcCase);
    
}