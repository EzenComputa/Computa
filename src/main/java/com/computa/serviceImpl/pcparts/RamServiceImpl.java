package com.computa.serviceImpl.pcparts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Ram;
import com.computa.persistence.pcparts.RamRepository;
import com.computa.service.pcparts.RamService;

@Service
@Qualifier("Ram")
public class RamServiceImpl implements RamService {

    @Autowired
    private RamRepository ramRepository;

    @Override
    public List<Ram> getAllRam() {
        return ramRepository.findAll();
    }

    @Override
    public Ram getRamById(Long id) {
        return ramRepository.findById(id).orElse(null);
    }

    @Override
    public Ram saveRam(Ram ram) {
        return ramRepository.save(ram);
    }

    @Override
    public void deleteRam(Long id) {
        ramRepository.deleteById(id);
    }

    @Override
    public void save(Ram product) {
        ramRepository.save(product);
    }
}