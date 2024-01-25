package com.computa.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import com.computa.entity.UsedProduct;

@SpringBootTest
public class UsedProductRepositoryTest {

    @Autowired
    UsedProductRepository UPRepo;

    @Test
    public void testSelectAll() {
        List<UsedProduct> list = UPRepo.findAll();

        for (UsedProduct record : list) {
            System.out.println(record.getId());
            System.out.println(record.getFullname());
            System.out.println(record.getProduct_state());
            System.out.println(record.getPrice());
            System.out.println(record.getUpdateview());
            System.out.println(record.getReg_day());
            System.out.println(record.getParts());
            System.out.println(record.getSalesStatus());
        }
    }
}
