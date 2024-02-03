package com.computa.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.UsedItemImg;

public interface UsedItemImgRepository extends JpaRepository<UsedItemImg, Long> {

    List<UsedItemImg> findByUseditem_IdOrderByIdAsc(Long usedItemId);

}
