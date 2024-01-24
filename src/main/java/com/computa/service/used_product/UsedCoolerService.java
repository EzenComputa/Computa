package com.computa.service.used_product;

import java.util.List;

import com.computa.entity.used_product.UsedCooler;

// CoolerService.java
public interface UsedCoolerService extends UsedProductService<UsedCooler> {
    List<UsedCooler> getAllCooler();

    UsedCooler getCoolerById(Long id);

    UsedCooler saveCooler(UsedCooler used_cooler);

    void deleteCooler(Long id);
}