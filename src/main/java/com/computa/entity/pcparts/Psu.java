package com.computa.entity.pcparts;

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
@Table(name = "psu")
public class Psu extends Product{
    
    @Column(name = "form_factor")
    private String formFactor;

    @Column(name = "wattage")
    private Integer wattage;

    @Column(name = "efficiency")
    private String efficiency;
}
