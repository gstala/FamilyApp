package com.stala.family.controller;

import com.stala.family.dto.ChildDto;
import com.stala.family.handler.ChildHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/child")
@CrossOrigin(origins = "http://localhost:4200")
public class ChildController {

    @Autowired
    private ChildHandler childHandler;

    @GetMapping("/{childId}")
    public ChildDto readChild(@PathVariable("childId") long childId) {
        return childHandler.readChild(childId);
    }

}
