package com.computa.serviceImpl.pcparts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Cooler;
import com.computa.persistence.pcparts.CoolerRepository;
import com.computa.service.pcparts.CoolerService;

@Service
@Qualifier("Cooler")
public class CoolerServiceImpl implements CoolerService {

    @Autowired
    private CoolerRepository coolerRepository;

    @Autowired
    public List<Cooler> getAllCooler() {
        return coolerRepository.findAll();
    }

    @Override
    public void save(Cooler product) {
        coolerRepository.save(product);
    }


    @Override
    public Cooler getCoolerById(Long id) {
        return coolerRepository.findById(id).orElse(null);
    }

    @Override
    public Cooler saveCooler(Cooler cooler) {
        return coolerRepository.save(cooler);
    }

    @Override
    public void deleteCooler(Long id) {
        coolerRepository.deleteById(id);
    }

}