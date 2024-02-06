package com.computa.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Gpu;

public interface GpuRepository extends JpaRepository<Gpu, Long>{

    List<Gpu> findAll();
    
}
