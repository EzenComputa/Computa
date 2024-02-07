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
@Table(name = "ram")
public class Ram extends Product{
    
    @Column(name = "module_type")
    private String moduleType;

    @Column(name = "kind")
    private String kind;

    @Column(name = "memForm")
    private String memForm;

    @Column(name = "memSize")
    private double memSize;

    @Column(name = "clock")
    private double clock;

    @Column(name = "rams")
    private Integer rams;
}
