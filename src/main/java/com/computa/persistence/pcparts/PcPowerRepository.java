package com.computa.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.PcPower;

public interface PcPowerRepository extends JpaRepository<PcPower, Long>{

    List<PcPower> findAll();
    
}
