package com.computa.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Cpu;

public interface CpuRepository extends JpaRepository<Cpu, Long>{
    
}
