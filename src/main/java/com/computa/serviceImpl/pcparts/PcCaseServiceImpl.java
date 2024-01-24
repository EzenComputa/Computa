package com.computa.serviceImpl.pcparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.PcCase;
import com.computa.persistence.pcparts.PcCaseRepository;
import com.computa.service.pcparts.PcCaseService;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("PcCase")
public class PcCaseServiceImpl implements PcCaseService {

    @Autowired
    private PcCaseRepository pcCaseRepository;

    @Override
    public List<PcCase> getAllPcCases() {
        return pcCaseRepository.findAll();
    }

    @Override
    public PcCase getPcCaseById(Long id) {
        Optional<PcCase> optionalPcCase = pcCaseRepository.findById(id);
        return optionalPcCase.orElse(null);
    }

    @Override
    public PcCase savePcCase(PcCase pcCase) {
        return pcCaseRepository.save(pcCase);
    }

    @Override
    public void deletePcCase(Long id) {
        pcCaseRepository.deleteById(id);
    }

    @Override
    public void save(PcCase product) {
        pcCaseRepository.save(product);
    }
}