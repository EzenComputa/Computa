package com.computa.persistence.pcparts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.PcPower;

<<<<<<< HEAD
public interface PowerRepository extends JpaRepository<Power, Long>{

    List<Power> findAll();
=======
public interface PowerRepository extends JpaRepository<PcPower, Long>{
>>>>>>> 83b34c1a39a9061793b88a691c9c71e80993fd7a
    
}
