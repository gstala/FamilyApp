package com.stala.family.dto;

import com.stala.family.model.Sex;

public class ChildDto extends AbstractPersonDto {

    private Sex sex;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
