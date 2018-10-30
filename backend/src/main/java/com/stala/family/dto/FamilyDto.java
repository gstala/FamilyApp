package com.stala.family.dto;

import java.util.List;

public class FamilyDto {

    private Long id;
    private FatherDto father;
    private List<ChildDto> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FatherDto getFather() {
        return father;
    }

    public void setFather(FatherDto father) {
        this.father = father;
    }

    public List<ChildDto> getChildren() {
        return children;
    }

    public void setChildren(List<ChildDto> children) {
        this.children = children;
    }

}
