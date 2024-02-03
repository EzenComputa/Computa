package com.computa.dto;

import com.computa.entity.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsedItemSearchDto {

    private String searchDateType;

    private ItemSellStatus searchSellStatus;

    private String searchBy;

    private String searchQuery = "";
}
