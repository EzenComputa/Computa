package com.computa.service.used_product;

import java.util.List;

import com.computa.entity.used_product.UsedGpu;

public interface UsedGpuService extends UsedProductService<UsedGpu> {
    List<UsedGpu> findAll();
}
