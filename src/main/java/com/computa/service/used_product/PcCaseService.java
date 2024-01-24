package com.computa.service.pcparts;

import java.util.List;

import com.computa.entity.pcparts.PcCase;
import com.computa.service.pcparts.ProductService;

public interface PcCaseService extends ProductService<PcCase> {
    List<PcCase> getAllPcCases();

    PcCase getPcCaseById(Long id);

    PcCase savePcCase(PcCase used_pc_case);

    void deletePcCase(Long id);
}