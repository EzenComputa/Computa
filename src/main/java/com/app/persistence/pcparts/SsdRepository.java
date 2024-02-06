package com.app.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.pcparts.Ssd;

public interface SsdRepository extends JpaRepository<Ssd, Long>{

    List<Ssd> findAll();
    
}
