package com.stala.family.service;

import com.stala.family.model.Child;
import com.stala.family.model.Family;
import com.stala.family.model.Father;

public interface FamilyService {
    Family createFamily();

    void addFatherToFamily(long familyId, Father father);

    void addChildToFamily(long familyId, Child child);

    Family readFamily(long familyId);
}
