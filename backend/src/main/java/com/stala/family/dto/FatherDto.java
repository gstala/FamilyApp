package com.stala.family.dto;

import java.util.Date;

public class FatherDto extends AbstractPersonDto {

    private Date birthDate;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
