package com.computa.persistence.used_product;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.computa.entity.pcparts.PcCase;

@Repository
public interface PcCaseRepository extends JpaRepository<PcCase, Long> {
}