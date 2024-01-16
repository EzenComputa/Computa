package com.computa.entity.pcparts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String  formFactor;

    @Column(name = "threads")
    private Integer threads;

    @Column(name = "ram_slots")
    private Integer ramSlots;
}
