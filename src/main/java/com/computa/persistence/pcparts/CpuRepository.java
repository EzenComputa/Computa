package com.computa.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Cpu;

public interface CpuRepository extends JpaRepository<Cpu, Long>{

    List<Cpu> findAll();
    
}
