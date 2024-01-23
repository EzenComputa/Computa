package com.computa.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.computa.entity.pcparts.PcStorage;

public interface PcStorageRepository extends JpaRepository<PcStorage, Long> {
}