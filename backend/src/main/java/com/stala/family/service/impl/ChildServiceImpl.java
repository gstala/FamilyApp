package com.stala.family.service.impl;

import com.stala.family.model.Child;
import com.stala.family.model.Sex;
import com.stala.family.repository.ChildRepository;
import com.stala.family.service.ChildService;
import com.stala.family.utill.ChildSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Override
    public Child readChild(long childId) {
        return childRepository.findById(childId).orElseThrow(() -> new NoSuchElementException("Child not found"));
    }

    @Override
    public List<Child> searchChild(String firstName, String secondName, String pesel, Sex sex) {
        return childRepository.findAll(prepareSearchSpecification(firstName, secondName, pesel, sex));
    }

    @Override
    public List<Child> findAllChildrenByFamily(long familyId) {
        return childRepository.findAllByFamilyId(familyId);
    }

    private Specification<Child> prepareSearchSpecification(String firstName, String secondName, String pesel, Sex sex) {
        Specification<Child> searchSpecification = Specification
                .where(ChildSpecification.firstNameLike(firstName != null ? firstName : ""))
                .and(ChildSpecification.secondNameLike(secondName != null ? secondName : ""))
                .and(ChildSpecification.peselLike(pesel != null ? pesel : ""));

        if (sex != null)
            searchSpecification.and(ChildSpecification.sexEquals(sex));

        return searchSpecification;
    }
}
