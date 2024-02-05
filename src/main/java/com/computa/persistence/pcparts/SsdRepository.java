package com.computa.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Ssd;

public interface SsdRepository extends JpaRepository<Ssd, Long>{
    
}
