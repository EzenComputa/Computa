package com.computa.dto;

import java.util.ArrayList;
import java.util.List;

import com.computa.entity.ItemSellStatus;
import com.computa.entity.Parts;
import com.computa.entity.UsedItem;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UsedItemFormDto {

    private Long id;

    @NotEmpty(message = "상품명은 필수 입력 값입니다.")
    private String usedItemNm; // 상품명

    @NotNull(message = "가격은 필수 입력 값입니다.")
    private Integer price; // 가격

    @NotEmpty(message = "상세 내용은 필수 입력 값입니다.")
    private String useditemDetail; // 상품 상세설명

    @NotNull(message = "재고는 필수 입력 값입니다.")
    private Integer stockNumber; // 재고수량

    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    private Parts parts;

    private List<UsedItemImgDto> usedItemImgDtoList = new ArrayList<>();

    private List<Long> usedItemImgIds = new ArrayList<>();

    @Builder
    public UsedItemFormDto(String usedItemNm, Integer price, String useditemDetail, Integer stockNumber,
            ItemSellStatus itemSellStatus, Parts parts) {
        this.usedItemNm = usedItemNm;
        this.price = price;
        this.stockNumber = stockNumber;
        this.useditemDetail = useditemDetail;
        this.itemSellStatus = itemSellStatus;
        this.parts = parts;
    }

    public UsedItem toEntity(UsedItemFormDto dto) {
        UsedItem entity = UsedItem.builder()
                .usedItemNm(dto.usedItemNm)
                .useditemDetail(dto.useditemDetail)
                .itemSellStatus(dto.itemSellStatus)
                .parts(dto.parts)
                .price(dto.price)
                .stockNumber(dto.stockNumber)
                .build();

        return entity;
    }

    public static UsedItemFormDto of(UsedItem entity) {
        UsedItemFormDto dto = UsedItemFormDto.builder()
                .usedItemNm(entity.getUsedItemNm())
                .useditemDetail(entity.getUseditemDetail())
                .itemSellStatus(entity.getItemSellStatus())
                .parts(entity.getParts())
                .price(entity.getPrice())
                .stockNumber(entity.getStockNumber())
                .build();

        return dto;
    }
}
