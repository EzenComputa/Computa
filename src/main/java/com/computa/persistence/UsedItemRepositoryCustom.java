package com.computa.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.computa.dto.UsedItemSearchDto;
import com.computa.entity.UsedItem;

public interface UsedItemRepositoryCustom {

    Page<UsedItem> getUserUsedItemPage(UsedItemSearchDto UsedItemSearchDto, Pageable pageable);

}