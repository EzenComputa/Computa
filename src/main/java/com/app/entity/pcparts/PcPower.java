package com.app.entity.pcparts;

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
@Table(name = "pc_power")
public class PcPower extends Product{

    @Column(name = "kind")
    private String kind;

    @Column(name = "rated")
    private Double rated;

    @Column(name = "plus80")
    private String plus80;

    @Column(name = "output12V")
    private Double output12V;

    @Column(name = "capacity12V")
    private Double capacity12V;

    @Column(name = "PFC")
    private Double PFC;

    @Column(name = "coolingCount")
    private Integer coolingCount;

    @Column(name = "barring")
    private Integer barring;

    @Column(name = "depth")
    private Double depth;

    @Column(name = "alimit")
    private Integer alimit;

    @Column(name = "DC3")
    private Double DC3;

    @Column(name = "DC5")
    private Double DC5;

    @Column(name = "DC12")
    private Double DC12;

    @Column(name = "DC12m")
    private Double DC12m;

    @Column(name = "DC5sb")
    private Double DC5sb;

    @Column(name = "cable")
    private String cable;

    @Column(name = "mainpower")
    private String mainpower;

    @Column(name = "subpower")
    private String subpower;

    @Column(name = "PCI8")
    private Integer PCI8;

    @Column(name = "SATA")
    private Integer SATA;

    @Column(name = "SATA3")
    private Integer SATA3;

    @Column(name = "IDE4")
    private Integer IDE4;
}
