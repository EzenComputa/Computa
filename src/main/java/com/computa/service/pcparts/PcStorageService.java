package com.computa.service.pcparts;

import java.util.List;

import com.computa.entity.pcparts.PcStorage;

public interface PcStorageService extends ProductService<PcStorage>{
    List<PcStorage> getAllPcStorage();
    PcStorage getPcStorageById(Long id);
    PcStorage savePcStorage(PcStorage pcStorage);
    void deletePcStorage(Long id);
}
