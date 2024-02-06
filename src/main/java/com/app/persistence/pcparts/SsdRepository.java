package com.app.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.pcparts.Ssd;

public interface SsdRepository extends JpaRepository<Ssd, Long>{
    
}
