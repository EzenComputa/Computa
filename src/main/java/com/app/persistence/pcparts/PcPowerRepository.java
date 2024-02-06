package com.app.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.pcparts.PcPower;

public interface PcPowerRepository extends JpaRepository<PcPower, Long>{

    List<PcPower> findAll();
    
}
