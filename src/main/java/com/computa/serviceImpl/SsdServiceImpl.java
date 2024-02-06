package com.computa.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.pcparts.Ssd;
import com.computa.persistence.pcparts.SsdRepository;
import com.computa.service.SsdService;

@Service
public class SsdServiceImpl implements SsdService {

    @Autowired
    private SsdRepository ssdRepository;

    @Override
    public void insertSsd(Ssd ssd){
        ssdRepository.save(ssd);
    }
    
}
