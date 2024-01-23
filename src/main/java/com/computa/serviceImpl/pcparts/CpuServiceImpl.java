package com.computa.serviceImpl.pcparts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Cpu;
import com.computa.persistence.pcparts.CpuRepository;
import com.computa.service.pcparts.CpuService;

@Service
@Qualifier("Cpu")
public class CpuServiceImpl implements CpuService {

    @Autowired
    private CpuRepository cpuRepository;

    @Override
    public List<Cpu> findAll() {
        return cpuRepository.findAll();
    }

    @Override
    public void save(Cpu product) {
        cpuRepository.save(product);
    }
}