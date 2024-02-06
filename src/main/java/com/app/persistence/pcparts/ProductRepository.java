package com.app.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.pcparts.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();
}