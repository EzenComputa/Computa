package com.computa.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Motherboard;
import com.computa.persistence.pcparts.MotherboardRepository;
import com.computa.service.MotherboardService;

@Service
public class MotherboardServiceImpl implements MotherboardService {

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Override
    public void insertMotherboard(Motherboard motherboard){
        motherboardRepository.save(motherboard);
    }
    
}
