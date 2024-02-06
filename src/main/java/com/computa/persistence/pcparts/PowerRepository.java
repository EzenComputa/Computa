package com.computa.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.PcPower;

public interface PowerRepository extends JpaRepository<PcPower, Long>{
    
}
