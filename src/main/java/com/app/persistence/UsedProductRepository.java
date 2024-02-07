package com.app.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.UsedProduct;

public interface UsedProductRepository extends JpaRepository<UsedProduct, Long> {


}
