package com.computa.service.pcparts;

import java.util.List;

import com.computa.entity.pcparts.Psu;

public interface PsuService extends ProductService<Psu>{
    List<Psu> getAllPsu();
    Psu getPsuById(Long id);
    Psu savePsu(Psu psu);
    void deletePsu(Long id);
}
