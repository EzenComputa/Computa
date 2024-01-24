package com.computa.entity.used_product;

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
@Table(name = "used_cpu")
public class UsedCpu extends UsedProduct {

    @Column(name = "socket")
    private String socket;

    @Column(name = "cores")
    private Integer cores;

    @Column(name = "threads")
    private Integer threads;
}
