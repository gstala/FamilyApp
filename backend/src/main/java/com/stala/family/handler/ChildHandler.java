package com.stala.family.handler;

import com.stala.family.dto.ChildDto;
import com.stala.family.model.Sex;

import java.util.List;

public interface ChildHandler {

    ChildDto readChild(long childId);

}
