package com.computa.service.pcparts;

import java.util.List;

import com.computa.entity.pcparts.Cooler;

// CoolerService.java
public interface CoolerService extends ProductService<Cooler>{
    List<Cooler> getAllCooler();
    Cooler getCoolerById(Long id);
    Cooler saveCooler(Cooler cooler);
    void deleteCooler(Long id);
}