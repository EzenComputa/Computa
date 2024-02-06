package com.app.entity.pcparts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Id
    @Column(nullable = false)
    private Long id;
    
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
