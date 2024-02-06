package com.computa.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Power;
import com.computa.persistence.pcparts.PowerRepository;
import com.computa.service.PowerService;

@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    private PowerRepository powerRepository;

    @Override
    public void insertPower(Power power){
        powerRepository.save(power);
    }
    
}
