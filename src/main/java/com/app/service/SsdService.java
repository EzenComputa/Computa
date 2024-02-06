package com.app.service;

import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Ssd;

@Service
public interface SsdService {

    void insertSsd(Ssd ssd);
    
}