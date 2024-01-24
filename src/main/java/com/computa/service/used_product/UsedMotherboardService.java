package com.computa.service.used_product;

import java.util.List;

import com.computa.entity.used_product.UsedMotherboard;

public interface UsedMotherboardService extends UsedProductService<UsedMotherboardService> {
    List<UsedMotherboard> getAllMotherboards();

    UsedMotherboard getMotherboardById(Long id);

    UsedMotherboard saveMotherboard(UsedMotherboard used_motherboard);

    void deleteMotherboard(Long id);
}