package com.computa.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Power;

public interface PowerRepository extends JpaRepository<Power, Long>{
    
}
