package com.computa.entity;

import com.computa.dto.UsedItemFormDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "used_item")
public class UsedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "used_item_id")
    private Long id; // 상품 코드

    @Column(nullable = false, length = 50)
    private String usedItemNm; // 상품명

    @Column(name = "price", nullable = false)
    private int price; // 가격

    @Column(nullable = false)
    private int stockNumber; // 재고수량

    @Lob
    @Column(nullable = false)
    private String useditemDetail; // 상품 상세설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    @Enumerated(EnumType.STRING)
    private Parts parts; // 상품 분류

    @Builder
    public UsedItem(String usedItemNm, int price, int stockNumber, String useditemDetail,
            ItemSellStatus itemSellStatus, Parts parts) {
        this.usedItemNm = usedItemNm;
        this.price = price;
        this.stockNumber = stockNumber;
        this.useditemDetail = useditemDetail;
        this.itemSellStatus = itemSellStatus;
        this.parts = parts;
    }

    public void updateUsedItem(UsedItemFormDto usedItemFormDto) {
        this.usedItemNm = usedItemFormDto.getUsedItemNm();
        this.price = usedItemFormDto.getPrice();
        this.stockNumber = usedItemFormDto.getStockNumber();
        this.useditemDetail = usedItemFormDto.getUseditemDetail();
        this.itemSellStatus = usedItemFormDto.getItemSellStatus();

    }
}
