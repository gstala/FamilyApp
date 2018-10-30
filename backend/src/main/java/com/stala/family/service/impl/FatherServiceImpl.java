package com.stala.family.service.impl;

import com.stala.family.model.Family;
import com.stala.family.model.Father;
import com.stala.family.repository.FatherRepository;
import com.stala.family.service.FatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FatherServiceImpl implements FatherService {

    @Autowired
    private FatherRepository fatherRepository;

    @Override
    public Father readFather(long fatherId) {
        return fatherRepository.findById(fatherId).orElseThrow(() -> new NoSuchElementException("Father not found"));
    }

    @Override
    public Father readFather(Family family) {
        return fatherRepository.findByFamilyId(family.getId()).orElseThrow(() -> new NoSuchElementException("Father not found"));
    }
}
