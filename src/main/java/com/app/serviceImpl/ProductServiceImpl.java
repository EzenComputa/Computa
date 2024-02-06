package com.app.serviceImpl;

import java.util.List;
import java.util.Optional;

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
    public Product getProductWithDetails(Long Id) {
        Optional<Product> optionalProduct = productRepository.findById(Id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            List<Ram> ramList = product.getRamList();
            // ramList를 통해 해당 제품에 연결된 RAM 정보들을 가져올 수 있음

        }
        return null;
    }
}