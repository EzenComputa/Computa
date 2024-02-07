package com.app.service;

import java.util.List;

import com.app.entity.Usedlist;

public interface UsedlistService {

List<Usedlist> gUsedlists(Long userId);

void addProductToUsedlist(Long userId, Long usedproductId);
}