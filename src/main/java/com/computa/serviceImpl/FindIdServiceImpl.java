package com.computa.serviceImpl;

import com.computa.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.persistence.FindIdRepository;
import com.computa.service.FindIdService;

@Service
public class FindIdServiceImpl implements FindIdService {

    private FindIdRepository findIdRepository;

    @Autowired
    public FindIdServiceImpl(FindIdRepository findIdRepository) {
        this.findIdRepository = findIdRepository;
    }

    public User getUserByName(String name) {
        return findIdRepository.findByName(name);
    }

    public String checkName(String name) {
        User user = findIdRepository.findByName(name);
        if (user == null) {
            return null;
        } else {
            return user.getUsername();
        }
    }
}
