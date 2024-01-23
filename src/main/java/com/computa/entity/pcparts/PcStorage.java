package com.computa.entity.pcparts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// capacity, storageType, formFactor

@Entity
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@Table(name = "pc_storage")
public class PcStorage extends Product{
    
    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "storage_type")
    private String storageType;

    @Column(name = "form_factor")
    private String formFactor;
}
