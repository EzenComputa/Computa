package com.app.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Hdd;
import com.app.persistence.pcparts.HddRepository;
import com.app.service.HddService;

@Service
public class HddServiceImpl implements HddService {

    @Autowired
    private HddRepository hddRepository;

    @Override
    public void insertHdd(Hdd hdd){
        hddRepository.save(hdd);
    }
    
}
