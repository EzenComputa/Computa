package com.app.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.pcparts.Ram;


public interface RamRepository extends JpaRepository<Ram, Long> {

    List<Ram> findAll();
}