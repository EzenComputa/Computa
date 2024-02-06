package com.app.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.pcparts.Motherboard;

@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
}