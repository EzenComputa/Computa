package com.computa.service.pcparts;

import java.util.List;

import com.computa.entity.pcparts.Motherboard;

public interface MotherboardService extends ProductService<Motherboard>{
    List<Motherboard> getAllMotherboards();
    Motherboard getMotherboardById(Long id);
    Motherboard saveMotherboard(Motherboard motherboard);
    void deleteMotherboard(Long id);
}