package com.stala.family.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Father extends Person {

    private Date birthDate;

    @OneToOne(optional = false)
    private Family family;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
