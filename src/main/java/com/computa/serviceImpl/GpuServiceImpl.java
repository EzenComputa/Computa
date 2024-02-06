package com.computa.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Gpu;
import com.computa.persistence.pcparts.GpuRepository;
import com.computa.service.GpuService;

@Service
public class GpuServiceImpl implements GpuService {

    @Autowired
    private GpuRepository gpuRepository;

    @Override
    public void insertGpu(Gpu gpu){
        gpuRepository.save(gpu);
    }
    
}
