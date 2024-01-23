package com.computa.entity.pcparts;

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
@Table(name = "motherboard")
public class Motherboard extends Product{
    
    @Column(name = "socket")
    private String socket;

    @Column(name = "form_factor")
    private String formFactor;

    @Column(name = "ram_slots")
    private Integer ramSlots;

    @Column(name = "max_ram")
    private Integer maxRam;
}
