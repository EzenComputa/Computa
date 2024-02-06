package com.app.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Ram;
import com.app.persistence.pcparts.RamRepository;
import com.app.service.RamService;

@Service
public class RamServiceImpl implements RamService{

    @Autowired
    private RamRepository ramRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void insertRam(Ram ram){
        ramRepository.save(ram);
    }

    // @Override
    // public Ram getRamDetail(Product product){
    //     Optional<Product> findRam = productRepository.findById(product.getId());

    //     if(findRam.isPresent()) {
    //         return findRam.get();
    //     } else {
    //         return null;
    //     }
    // }

    // @Override
    // public ProductWithRamDetails getProductWithRamDetails(Long productId) {
    //     Optional<Product> optionalProduct = productRepository.findById(productId);
    //     if (optionalProduct.isPresent()) {
    //         Product product = optionalProduct.get();
    //         Long ramId = product.getRamId(); // Product 엔터티에 있는 Ram의 ID를 가져옴
    //         Optional<Ram> optionalRam = ramRepository.findById(ramId);
    //         if (optionalRam.isPresent()) {
    //             Ram ram = optionalRam.get();
    //             // Product와 Ram의 값을 결합하여 새로운 객체에 저장하여 반환
    //             return new ProductWithRamDetails(product, ram);
    //         }
    //     }
    //     return null;
    // }

}