package com.app.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.pcparts.Ram;
import com.app.persistence.pcparts.RamRepository;
import com.app.service.RamService;

@Service
public class RamServiceImpl implements RamService{

    @Autowired
    private RamRepository ramRepository;

    @Override
    public void insertRam(Ram ram){
        ramRepository.save(ram);
    }

}