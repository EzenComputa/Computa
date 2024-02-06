package com.computa.service;

import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.PcCase;

@Service
public interface PcCaseService {

    void insertPcCase(PcCase pcCase);
    
}