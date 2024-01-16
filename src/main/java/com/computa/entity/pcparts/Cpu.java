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
public class Cpu extends Product{
    
    @Column(name = "socket")
    private String socket;

    @Column(name = "cores")
    private Integer cores;

    @Column(name = "threads")
    private Integer threads;
}
