package com.computa.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Gpu;

public interface GpuRepository extends JpaRepository<Gpu, Long>{
    
}
