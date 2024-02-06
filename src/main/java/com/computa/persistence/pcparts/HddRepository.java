package com.computa.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Hdd;

public interface HddRepository extends JpaRepository<Hdd, Long>{

    List<Hdd> findAll();
    
}
