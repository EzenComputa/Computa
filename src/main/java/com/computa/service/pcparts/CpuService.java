package com.computa.service.pcparts;

import java.util.List;

import com.computa.entity.pcparts.Cpu;

public interface CpuService extends ProductService<Cpu>{
    List<Cpu> findAll();
}
