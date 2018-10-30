package com.stala.family.service;

import com.stala.family.model.Child;
import com.stala.family.model.Sex;

import java.util.List;

public interface ChildService {

    Child readChild(long childId);

    List<Child> searchChild(String firstName, String secondName, String pesel, Sex sex);

    List<Child> findAllChildrenByFamily(long familyId);
}
