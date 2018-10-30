package com.stala.family.service.impl;

import com.stala.family.model.Child;
import com.stala.family.model.Family;
import com.stala.family.model.Father;
import com.stala.family.repository.ChildRepository;
import com.stala.family.repository.FamilyRepository;
import com.stala.family.repository.FatherRepository;
import com.stala.family.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private FatherRepository fatherRepository;

    @Override
    public Family createFamily() {
        return familyRepository.saveAndFlush(new Family());
    }

    @Override
    public void addFatherToFamily(long familyId, Father father) {
        Family family = readFamily(familyId);
        father.setFamily(family);
        fatherRepository.save(father);
    }

    @Override
    public void addChildToFamily(long familyId, Child child) {
        Family family = readFamily(familyId);
        child.setFamily(family);
        childRepository.save(child);
    }

    @Override
    public Family readFamily(long familyId) {
        return familyRepository.findById(familyId).orElseThrow(() -> new NoSuchElementException("Family not found"));
    }
}
