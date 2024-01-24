package com.computa.service.pcparts;

import java.util.List;

import com.computa.entity.pcparts.Ram;

public interface RamService extends ProductService<Ram>{
    List<Ram> getAllRam();
    Ram getRamById(Long id);
    Ram saveRam(Ram ram);
    void deleteRam(Long id);
}