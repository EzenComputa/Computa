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
@Table(name = "cpu")
public class Cpu extends Product {

    @Column(name = "socket")
    private String socket;

    @Column(name = "cores")
    private Integer cores;

    @Column(name = "threads")
    private Integer threads;

    @Column(name = "kinds")
    private String kinds;

    @Column(name = "factory")
    private Integer factory;

    @Column(name = "PCIe")
    private String PCIe;

    @Column(name = "gen")
    private String gen;
    
    @Column(name = "reldate")
    private String reldate;
    
    @Column(name = "basicClock")
    private Integer basicClock;

    @Column(name = "maxClock")
    private Integer maxClock;

    @Column(name = "L2")
    private Integer L2;

    @Column(name = "L3")
    private Integer L3;

    @Column(name = "calSys")
    private String calSys;

    @Column(name = "memSize")
    private Integer memSize;

    @Column(name = "memClock")
    private Integer memClock;

    @Column(name = "memCh")
    private Integer memCh;

    @Column(name = "gpu")
    private Boolean gpu;

    @Column(name = "gpuName")
    private String gpuName;

    @Column(name = "gpuSpeed")
    private Integer gpuSpeed;

    @Column(name = "packageForm")
    private String packageForm;

    @Column(name = "cooler")
    private String cooler;

}