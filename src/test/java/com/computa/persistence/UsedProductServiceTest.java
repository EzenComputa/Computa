package com.computa.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDateTime;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.computa.entity.ItemSellStatus;
import com.computa.entity.UsedProduct;
import com.computa.entity.User;
import com.computa.service.UsedProductService;

@ExtendWith(MockitoExtension.class)
public class UsedProductServiceTest {
    @InjectMocks
    private UsedProductService target;

    @Mock
    private UsedProductRepository usedProductRepository;

    final User user = User.builder()
        .username("홍홍홍")//username은 user의 id
        .nickname("hong")
        .name("홍길동")
        .email("test@email.com")
        .phone("010-1111-2222")
        .password("12345")
        .ssid("951111-1123154")
        .reportcount(0)
        .build();

    @Test
    public void 아이템등록실패(){
        final UsedProduct usedproduct = UsedProduct.builder()
                .itemName("상품명")
                .itemDetail("상품설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .price(30000)
                .reg_DateTime(LocalDateTime.now())
                .build();

        UsedProduct result = target.saveUsedProduct(usedproduct);

        assertThat(result).isNull();
    }

    @Test
    public void 아이템등록_성공(){
        //given
        final UsedProduct usedproduct = UsedProduct.builder()
                .itemName("상품")
                .itemDetail("설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .price(30000)
                .build();
        doReturn(usedproduct).when(usedProductRepository).save(any(UsedProduct.class));

        //when
        final UsedProduct result = target.saveUsedProduct(usedproduct);

        //then
        assertThat(result).isEqualTo(usedproduct);
}
}


