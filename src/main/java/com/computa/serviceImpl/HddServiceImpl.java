package com.computa.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Hdd;
import com.computa.persistence.pcparts.HddRepository;
import com.computa.service.HddService;

@Service
public class HddServiceImpl implements HddService {

    @Autowired
    private HddRepository hddRepository;

    @Override
    public void insertHdd(Hdd hdd){
        hddRepository.save(hdd);
    }
    
}
