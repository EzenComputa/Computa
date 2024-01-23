package com.computa.serviceImpl.pcparts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Psu;
import com.computa.persistence.pcparts.PsuRepository;
import com.computa.service.pcparts.PsuService;

@Service
@Qualifier("Psu")
public class PsuServiceImpl implements PsuService {

    @Autowired
    private PsuRepository psuRepository;

    @Override
    public List<Psu> getAllPsu() {
        return psuRepository.findAll();
    }

    @Override
    public Psu getPsuById(Long id) {
        return psuRepository.findById(id).orElse(null);
    }

    @Override
    public Psu savePsu(Psu psu) {
        return psuRepository.save(psu);
    }

    @Override
    public void deletePsu(Long id) {
        psuRepository.deleteById(id);
    }

    @Override
    public void save(Psu product) {
        psuRepository.save(product);
    }
}