package com.computa.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.computa.entity.pcparts.Psu;

public interface PsuRepository extends JpaRepository<Psu, Long> {
}