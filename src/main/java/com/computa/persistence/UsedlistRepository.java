package com.computa.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.Usedlist;

public interface UsedlistRepository extends JpaRepository<Usedlist, Long> {
    List<Usedlist> findByUserId(Long userId);
}
