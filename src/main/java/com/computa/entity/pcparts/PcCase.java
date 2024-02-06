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
@Table(name = "pc_case")
public class PcCase extends Product {

    @Column(name = "form_factor")
    private String formFactor;

    @Column(name = "kinds")
    private String kinds;

    @Column(name = "power")
    private boolean power;

    @Column(name = "basicAtx")
    private boolean basicAtx;

    @Column(name = "microAtx")
    private boolean microAtx;

    @Column(name = "mini-itx")
    private boolean miniItx;

    @Column(name = "bay8")
    private Integer bay8;

    @Column(name = "bay6")
    private Integer bay6;

    @Column(name = "saver")
    private Integer saver;

    @Column(name = "size")
    private Integer size;
    
    @Column(name = "coolfan")
    private Integer coolfan;

    @Column(name = "LEDfan")
    private Integer LEDfan;

    @Column(name = "frontpan")
    private String frontpan;

    @Column(name = "sidepan")
    private String sidepan;

    @Column(name = "backsize")
    private Double backsize;

    @Column(name = "frontsize")
    private Double frontsize;

    @Column(name = "upsize")
    private Double upsize;

    @Column(name = "USB")
    private boolean USB;

    @Column(name = "USB3")
    private boolean USB3;

    @Column(name = "width")
    private Double width;

    @Column(name = "Depth")
    private Double depth;    
}
