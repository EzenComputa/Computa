package com.computa.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computa.entity.pcparts.Motherboard;

@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
}