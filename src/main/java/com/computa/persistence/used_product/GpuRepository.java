package com.computa.persistence.used_product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Gpu;

public interface GpuRepository extends JpaRepository<Gpu, Long> {

}
