package com.app.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.pcparts.PcCase;

public interface PcCaseRepository extends JpaRepository<PcCase, Long>{

    List<PcCase> findAll();
    
}
