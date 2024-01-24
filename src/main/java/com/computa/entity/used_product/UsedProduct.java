package com.computa.entity.used_product;

import java.util.ArrayList;
import java.util.List;

import com.computa.entity.UsedProductImage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

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
    private String fullname = new String();

    private String productType;

    @Temporal(TemporalType.DATE)
    Date regDate;

    @Temporal(TemporalType.TIME)
    Date regTime;

    @OneToMany(mappedBy = "used_product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UsedProductImage> usedproductImages = new ArrayList<>();

}
