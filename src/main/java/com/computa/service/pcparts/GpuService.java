package com.computa.service.pcparts;

import java.util.List;

import com.computa.entity.pcparts.Gpu;

public interface GpuService extends ProductService<Gpu> {
    List<Gpu> findAll();
}
