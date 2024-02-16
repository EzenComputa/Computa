package com.app.serviceImpl;

import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Product;
import com.app.persistence.pcparts.ProductRepository;
import com.app.service.ProductService;

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

    @Override
    public Product getProductById(Long productId){
        return productRepository.findById(productId).orElse(null);
    }
}