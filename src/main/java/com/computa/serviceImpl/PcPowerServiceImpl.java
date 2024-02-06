package com.computa.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.PcPower;
import com.computa.persistence.pcparts.PcPowerRepository;
import com.computa.service.PcPowerService;

@Service
public class PcPowerServiceImpl implements PcPowerService {

    @Autowired
    private PcPowerRepository pcpowerRepository;

    @Override
    public void insertPcPower(PcPower pcpower){
        pcpowerRepository.save(pcpower);
    }
    
}
