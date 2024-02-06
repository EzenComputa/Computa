package com.computa.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Power;

public interface PowerRepository extends JpaRepository<Power, Long>{

    List<Power> findAll();
    
}
