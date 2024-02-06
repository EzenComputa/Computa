package com.computa.serviceImpl;

import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Product;
import com.computa.persistence.pcparts.ProductRepository;
import com.computa.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void insertProduct(Product product){
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product){
        // 추가 수정
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product){
        productRepository.delete(product);
    }
}