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
@Table(name = "cooler")
public class Cooler extends Product{
    
    @Column(name = "rpm_min")
    private Integer rpmMin;

    @Column(name = "rpm_max")
    private Integer rpmMax;
}
