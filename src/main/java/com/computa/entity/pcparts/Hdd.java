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
@Table(name = "hdd")
public class Hdd extends Product{
    
    @Column(name = "kinds")
    private String kinds;

    @Column(name = "diskformsize")
    private Double diskformsize;

    @Column(name = "disksize")
    private Double disksize;

    @Column(name = "hddinterface")
    private String hddinterface;

    @Column(name = "rotatecount")
    private Double rotatecount;

    @Column(name = "buffersize")
    private Double buffersize;

    @Column(name = "sendspeed")
    private Double sendspeed;

    @Column(name = "record")
    private String record;

    @Column(name = "thick")
    private Double thick;

    @Column(name = "sound")
    private Double sound;
}
