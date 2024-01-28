package com.computa.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import com.computa.entity.ItemSellStatus;
import com.computa.entity.UsedProduct;

@SpringBootTest
public class UsedProductRepositoryTest {

    @Autowired
    UsedProductRepository UPRepo;

    @Test
    public void 아이템등록(){
        final UsedProduct usedproduct = UsedProduct.builder()
                .itemName("상품명")
                .itemDetail("상품설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .price(30000)
                .reg_DateTime(LocalDateTime.now())
                .build();

        final UsedProduct result = UPRepo.save(usedproduct);

        assertThat(result).isEqualTo(usedproduct);

        
    }
    }

