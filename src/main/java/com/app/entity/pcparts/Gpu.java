package com.app.entity.pcparts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@Table(name = "gpu")
public class Gpu extends Product{
    
    @Column(name = "vram")
    @Digits(fraction = 0, integer = 2)
    private Integer vram;

    @Column(name = "chipCompany")
    private String chipCompany;

    @Column(name = "kinds")
    private String kinds;

    @Column(name = "kudaprocess")
    private Integer kudaprocess;

    @Column(name = "chipset")
    private String chipset;

    @Column(name = "interfaceGpu")
    private String interfaceGpu;

    @Column(name = "memKind")
    private String memKind;

    @Column(name = "memBus")
    private Integer memBus;

    @Column(name = "memSize")
    private Integer memSize;

    @Column(name = "maxMoniter")
    private Integer maxMoniter;

    @Column(name = "displayport")
    private Integer displayport;

    @Column(name = "zerofan")
    private Boolean zerofan;

    @Column(name = "disp8K")
    private Boolean disp8k;

    @Column(name = "disp4K")
    private Boolean disp4K;

    @Column(name = "HDR")
    private Boolean HDR;

    @Column(name = "HDCP")
    private Boolean HDCP;

    @Column(name = "maxpower")
    private Integer maxpower;

    @Column(name = "protectheat")
    private Boolean protectheat;

    @Column(name = "heatpipe")
    private Boolean heatpipe;

    @Column(name = "fancooler")
    private Boolean fancooler;

    @Column(name = "fancount")
    private Integer fancount;

    @Column(name = "width")
    private Integer width;
}