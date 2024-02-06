package com.app.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.pcparts.PcPower;

public interface PowerRepository extends JpaRepository<PcPower, Long>{
    
}
