package com.app.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Motherboard;
import com.app.persistence.pcparts.MotherboardRepository;
import com.app.service.MotherboardService;

@Service
public class MotherboardServiceImpl implements MotherboardService {

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Override
    public void insertMotherboard(Motherboard motherboard){
        motherboardRepository.save(motherboard);
    }
    
}
