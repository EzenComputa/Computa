package com.app.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.pcparts.Hdd;

public interface HddRepository extends JpaRepository<Hdd, Long>{
    
}
