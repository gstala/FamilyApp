package com.stala.family.dto;

public class FamilyListDto {

    private Long id;
    private FatherDto father;

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
}
