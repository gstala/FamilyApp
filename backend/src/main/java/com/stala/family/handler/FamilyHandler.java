package com.stala.family.handler;

import com.stala.family.dto.FamilyDto;
import com.stala.family.dto.FamilyListDto;
import com.stala.family.model.Child;
import com.stala.family.model.Father;
import com.stala.family.model.Sex;

import java.util.List;

public interface FamilyHandler {

    FamilyDto createFamily();

    void addFatherToFamily(long familyId, Father father);

    void addChildToFamily(long familyId, Child child);

    FamilyDto readFamily(long familyId);

    List<FamilyListDto> searchFamily(String childFirstName, String childSecondName, String childPesel, Sex childSex);
}
