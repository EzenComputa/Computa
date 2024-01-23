package com.computa.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.computa.entity.pcparts.Ram;

public interface RamRepository extends JpaRepository<Ram, Long> {
}