package com.computa.entity.used_product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// capacity, storageType, formFactor

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "used_pc_storage")
public class UsedPcStorage extends UsedProduct {

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "storage_type")
    private String storageType;

    @Column(name = "form_factor")
    private String formFactor;
}
