package com.stala.family.handler.impl;

import com.stala.family.dto.ChildDto;
import com.stala.family.handler.ChildHandler;
import com.stala.family.service.ChildService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildHandlerImpl implements ChildHandler {

    @Autowired
    private ChildService childService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ChildDto readChild(long childId) {
        return modelMapper.map(childService.readChild(childId), ChildDto.class);
    }

}
