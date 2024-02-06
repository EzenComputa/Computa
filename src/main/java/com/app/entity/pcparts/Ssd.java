package com.app.entity.pcparts;

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
@Table(name = "ssd")
public class Ssd extends Product{
    
    @Column(name = "formfactor")
    private String formfactor;

    @Column(name = "kind")
    private String kind;

    @Column(name = "ssdInterface")
    private String ssdInterface;

    @Column(name = "size")
    private double size;

    @Column(name = "memType")
    private String memType;

    @Column(name = "nand")
    private String nand;

    @Column(name = "ram")
    private boolean ram;
}
