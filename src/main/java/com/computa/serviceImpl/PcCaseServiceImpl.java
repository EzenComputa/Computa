package com.computa.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.PcCase;
import com.computa.persistence.pcparts.PcCaseRepository;
import com.computa.service.PcCaseService;

@Service
public class PcCaseServiceImpl implements PcCaseService {

    @Autowired
    private PcCaseRepository pcCaseRepository;

    @Override
    public void insertPcCase(PcCase pcCase){
        pcCaseRepository.save(pcCase);
    }
    
}
