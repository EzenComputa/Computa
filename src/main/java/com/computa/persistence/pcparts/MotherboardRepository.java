package com.computa.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Motherboard;

public interface MotherboardRepository extends JpaRepository<Motherboard, Long>{

    List<Motherboard> findAll();
    
}
