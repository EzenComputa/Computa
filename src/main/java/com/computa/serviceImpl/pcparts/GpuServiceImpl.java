package com.computa.serviceImpl.pcparts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Gpu;
import com.computa.persistence.pcparts.GpuRepository;
import com.computa.service.pcparts.GpuService;

@Service
@Qualifier("Gpu")
public class GpuServiceImpl implements GpuService {

    @Autowired
    private GpuRepository gpuRepository;

    @Override
    public List<Gpu> findAll() {
        return gpuRepository.findAll();
    }

    @Override
    public void save(Gpu product) {
        gpuRepository.save(product);
    }
}