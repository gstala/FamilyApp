package com.stala.family.controller;

import com.stala.family.dto.FamilyDto;
import com.stala.family.dto.FamilyListDto;
import com.stala.family.handler.FamilyHandler;
import com.stala.family.model.Child;
import com.stala.family.model.Father;
import com.stala.family.model.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family")
@CrossOrigin(origins = "http://localhost:4200")
public class FamilyController {

    @Autowired
    private FamilyHandler familyHandler;

    @PostMapping
    public FamilyDto createFamily() {
        return familyHandler.createFamily();
    }

    @GetMapping("/{familyId}")
    public FamilyDto readFamily(@PathVariable("familyId") long familyId) {
        return familyHandler.readFamily(familyId);
    }

    @PostMapping("/{familyId}/father")
    public void addFatherToFamily(@PathVariable("familyId") long familyId, @RequestBody Father father) {
        familyHandler.addFatherToFamily(familyId, father);
    }

    @PostMapping("/{familyId}/children")
    public void addChildToFamily(@PathVariable("familyId") long familyId, @RequestBody Child child) {
        familyHandler.addChildToFamily(familyId, child);
    }

    @GetMapping("/search")
    public List<FamilyListDto> searchFamily(@RequestParam(name = "childFirstName", required = false) String childFirstName,
                                            @RequestParam(name = "childSecondName", required = false) String childSecondName,
                                            @RequestParam(name = "childPesel", required = false) String childPesel,
                                            @RequestParam(name = "childSex", required = false) Sex childSex) {

        return familyHandler.searchFamily(childFirstName, childSecondName, childPesel, childSex);
    }
}
