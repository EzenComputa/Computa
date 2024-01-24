package com.computa.service.used_product;

import java.util.List;

import com.computa.entity.used_product.UsedCpu;

public interface UsedCpuService extends UsedProductService<UsedCpu> {
    List<UsedCpu> findAll();
}
