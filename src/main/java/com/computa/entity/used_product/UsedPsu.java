package com.computa.entity.used_product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// formFactor, wattage, efficiency

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "used_psu")
public class UsedPsu extends UsedProduct {

    @Column(name = "form_factor")
    private String formFactor;

    @Column(name = "wattage")
    private Integer wattage;

    @Column(name = "efficiency")
    private String efficiency;
}
