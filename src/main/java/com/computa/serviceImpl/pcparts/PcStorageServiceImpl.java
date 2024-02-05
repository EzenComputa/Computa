package com.computa.serviceImpl.pcparts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.PcStorage;
import com.computa.persistence.pcparts.PcStorageRepository;
import com.computa.service.pcparts.PcStorageService;

@Service
@Qualifier("PcStorage")
public class PcStorageServiceImpl implements PcStorageService {

    @Autowired
    private PcStorageRepository pcStorageRepository;

    @Override
    public List<PcStorage> getAllPcStorage() {
        return pcStorageRepository.findAll();
    }

    @Override
    public PcStorage getPcStorageById(Long id) {
        return pcStorageRepository.findById(id).orElse(null);
    }

    @Override
    public PcStorage savePcStorage(PcStorage pcStorage) {
        return pcStorageRepository.save(pcStorage);
    }

    @Override
    public void deletePcStorage(Long id) {
        pcStorageRepository.deleteById(id);
    }

    @Override
    public void save(PcStorage product) {
        pcStorageRepository.save(product);
    }
}