package com.computa.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public enum SalesStatus {
    ON_SALE("판매중"),
    RESERVED("예약중"),
    SOLD_OUT("판매완료");

    private final String status;

    // SaleStatus(String status) {
    // this.status = status;
    // }

    // public String getStatus() {
    // return status;
    // }

}