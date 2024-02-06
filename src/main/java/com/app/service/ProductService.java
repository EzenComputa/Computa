package com.app.service;

import java.util.List;

import com.app.entity.pcparts.Product;


public interface ProductService {
    // List<ProductService> getAllProductServices();
    // List<ProductService> getProductServicesByProductId(Long productId);
    // ProductService getProductServiceById(Long id);
    // ProductService saveProductService(Long productId, Long userId, Long parentId, String content);
    // void deleteProductService(Long id);

    void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}