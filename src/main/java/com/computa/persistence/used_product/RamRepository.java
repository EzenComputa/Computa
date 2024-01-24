package com.computa.persistence.used_product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Ram;

public interface RamRepository extends JpaRepository<Ram, Long> {
}