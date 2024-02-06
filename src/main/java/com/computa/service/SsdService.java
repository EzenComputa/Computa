package com.computa.service;

import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Ssd;

@Service
public interface SsdService {

    void insertSsd(Ssd ssd);
    
}