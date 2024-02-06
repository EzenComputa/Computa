package com.app.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Cpu;
import com.app.persistence.pcparts.CpuRepository;
import com.app.service.CpuService;

@Service
public class CpuServiceImpl implements CpuService {

    @Autowired
    private CpuRepository cpuRepository;

    @Override
    public void insertCpu(Cpu cpu){
        cpuRepository.save(cpu);
    }
    
}
