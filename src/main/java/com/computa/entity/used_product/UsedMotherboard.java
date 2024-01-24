package com.computa.entity.used_product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// socket, formFactor, ramSlots, maxRam

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "used_motherboard")
public class UsedMotherboard extends UsedProduct {

    @Column(name = "socket")
    private String socket;

    @Column(name = "form_factor")
    private String formFactor;

    @Column(name = "ram_slots")
    private Integer ramSlots;

    @Column(name = "max_ram")
    private Integer maxRam;
}
