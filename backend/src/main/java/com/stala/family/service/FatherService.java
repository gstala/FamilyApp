package com.stala.family.service;

import com.stala.family.model.Family;
import com.stala.family.model.Father;

public interface FatherService {
    Father readFather(long fatherId);

    Father readFather(Family family);
}
