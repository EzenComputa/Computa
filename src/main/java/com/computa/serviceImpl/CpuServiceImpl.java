package com.computa.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Cpu;
import com.computa.persistence.pcparts.CpuRepository;
import com.computa.service.CpuService;

@Service
public class CpuServiceImpl implements CpuService {

    @Autowired
    private CpuRepository cpuRepository;

    @Override
    public void insertCpu(Cpu cpu){
        cpuRepository.save(cpu);
    }
    
}
