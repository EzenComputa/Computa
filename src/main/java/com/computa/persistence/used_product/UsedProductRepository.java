package com.computa.persistence.used_product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.used_product.UsedProduct;

public interface UsedProductRepository extends JpaRepository<UsedProduct, Long> {

}
