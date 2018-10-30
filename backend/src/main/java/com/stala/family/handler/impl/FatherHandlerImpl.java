package com.stala.family.handler.impl;

import com.stala.family.dto.FatherDto;
import com.stala.family.handler.FatherHandler;
import com.stala.family.service.FatherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FatherHandlerImpl implements FatherHandler {

    @Autowired
    private FatherService fatherService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FatherDto readFather(long fatherId) {
        return modelMapper.map(fatherService.readFather(fatherId), FatherDto.class);
    }
}
