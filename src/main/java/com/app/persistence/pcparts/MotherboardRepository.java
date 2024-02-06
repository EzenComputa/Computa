package com.app.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.pcparts.Motherboard;

public interface MotherboardRepository extends JpaRepository<Motherboard, Long>{

    List<Motherboard> findAll();
    
}
