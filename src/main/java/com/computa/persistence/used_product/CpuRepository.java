package com.computa.persistence.used_product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Cpu;

public interface CpuRepository extends JpaRepository<Cpu, Long> {

}
