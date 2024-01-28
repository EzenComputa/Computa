package com.computa.service;

import org.springframework.stereotype.Service;

import com.computa.entity.UsedProduct;
import com.computa.persistence.UsedProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public class UsedProductService {
    private final UsedProductRepository usedProductRepository;

    public UsedProduct saveUsedProduct(UsedProduct usedProduct){
        return usedProductRepository.save(usedProduct);
    }
}

