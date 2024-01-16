package com.computa.service.pcparts;

import java.util.List;

import com.computa.entity.pcparts.PcCase;


public interface PcCaseService {
    List<PcCase> getAllPcCases();
    PcCase getPcCaseById(Long id);
    PcCase savePcCase(PcCase pcCase);
    void deletePcCase(Long id);
}