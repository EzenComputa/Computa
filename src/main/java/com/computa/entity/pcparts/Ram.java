package com.computa.entity.pcparts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// moduleType, speed, modules, moduleSize

@Entity
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@Table(name = "ram")
public class Ram extends Product{
    
    @Column(name = "module_type")
    private String moduleType;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "modules")
    private Integer modules;

    @Column(name = "module_size")
    private Integer moduleSize;
}
