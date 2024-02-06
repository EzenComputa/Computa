package com.app.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Gpu;
import com.app.persistence.pcparts.GpuRepository;
import com.app.service.GpuService;

@Service
public class GpuServiceImpl implements GpuService {

    @Autowired
    private GpuRepository gpuRepository;

    @Override
    public void insertGpu(Gpu gpu){
        gpuRepository.save(gpu);
    }
    
}
