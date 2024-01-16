package com.computa.serviceImpl.pcparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Motherboard;
import com.computa.persistence.pcparts.MotherboardRepository;
import com.computa.service.pcparts.MotherboardService;

import java.util.List;
import java.util.Optional;

@Service
public class MotherboardServiceImpl implements MotherboardService {

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Override
    public List<Motherboard> getAllMotherboards() {
        return motherboardRepository.findAll();
    }

    @Override
    public Motherboard getMotherboardById(Long id) {
        Optional<Motherboard> optionalMotherboard = motherboardRepository.findById(id);
        return optionalMotherboard.orElse(null);
    }

    @Override
    public Motherboard saveMotherboard(Motherboard motherboard) {
        return motherboardRepository.save(motherboard);
    }

    @Override
    public void deleteMotherboard(Long id) {
        motherboardRepository.deleteById(id);
    }
}