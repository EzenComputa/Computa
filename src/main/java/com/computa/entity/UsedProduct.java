package com.computa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UsedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    private String product_state;

    private Integer price;

    private Integer updateview;

    // @OneToMany(mappedBy = "used_product", cascade = CascadeType.ALL, fetch =
    // FetchType.LAZY)
    // private List<UsedProductImage> usedproductImages = new ArrayList<>();

    private LocalDateTime reg_day;

    // 부품종류
    @Enumerated(EnumType.STRING)
    private Parts parts;

    // 판매현황
    @Enumerated(EnumType.STRING)
    private SalesStatus SalesStatus;

}
