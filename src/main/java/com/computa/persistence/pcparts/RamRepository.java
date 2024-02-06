package com.computa.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.computa.entity.pcparts.Ram;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RamRepository extends JpaRepository<Ram, Long> {

    List<Ram> findAll();
}