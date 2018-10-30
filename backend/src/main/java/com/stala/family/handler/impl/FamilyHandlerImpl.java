package com.stala.family.handler.impl;

import com.stala.family.dto.ChildDto;
import com.stala.family.dto.FamilyDto;
import com.stala.family.dto.FamilyListDto;
import com.stala.family.dto.FatherDto;
import com.stala.family.handler.FamilyHandler;
import com.stala.family.model.Child;
import com.stala.family.model.Family;
import com.stala.family.model.Father;
import com.stala.family.model.Sex;
import com.stala.family.service.ChildService;
import com.stala.family.service.FamilyService;
import com.stala.family.service.FatherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FamilyHandlerImpl implements FamilyHandler {

    @Autowired
    private FamilyService familyService;
    @Autowired
    private FatherService fatherService;
    @Autowired
    private ChildService childService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FamilyDto createFamily() {
        return modelMapper.map(familyService.createFamily(), FamilyDto.class);
    }

    @Override
    public void addFatherToFamily(long familyId, Father father) {
        familyService.addFatherToFamily(familyId, father);
    }

    @Override
    public void addChildToFamily(long familyId, Child child) {
        familyService.addChildToFamily(familyId, child);
    }

    @Override
    public FamilyDto readFamily(long familyId) {
        Family family = familyService.readFamily(familyId);
        FamilyDto familyDto = modelMapper.map(family, FamilyDto.class);
        familyDto.setChildren(childService.findAllChildrenByFamily(familyId)
                .stream()
                .map(x -> modelMapper.map(x, ChildDto.class))
                .collect(Collectors.toList())
        );
        familyDto.setFather(modelMapper.map(fatherService.readFather(family), FatherDto.class));
        return familyDto;
    }

    @Override
    public List<FamilyListDto> searchFamily(String childFirstName, String childSecondName, String childPesel, Sex childSex) {
        List<Child> children = childService.searchChild(childFirstName, childSecondName, childPesel, childSex);
        Set<Family> families = new HashSet<>();
        children.forEach(x -> families.add(x.getFamily()));
        return families.stream().map(x -> {
            FamilyListDto familyListDto = new FamilyListDto();
            familyListDto.setId(x.getId());
            familyListDto.setFather(modelMapper.map(fatherService.readFather(x), FatherDto.class));
            return familyListDto;
        }).collect(Collectors.toList());
    }
}
