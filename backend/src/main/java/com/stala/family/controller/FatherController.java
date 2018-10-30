package com.stala.family.controller;

import com.stala.family.dto.FatherDto;
import com.stala.family.handler.FatherHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/father")
@CrossOrigin(origins = "http://localhost:4200")
public class FatherController {

    @Autowired
    private FatherHandler fatherHandler;

    @GetMapping("/{fatherId}")
    public FatherDto readFather(@PathVariable("fatherId") long fatherId) {
        return fatherHandler.readFather(fatherId);
    }
}
