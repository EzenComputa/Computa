package com.computa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.UsedItem;

public interface UsedItemRepository extends JpaRepository<UsedItem, Long> {

}
