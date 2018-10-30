package com.stala.family.model;

import javax.persistence.*;

@Entity
public class Child extends Person {

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne(optional = false)
    private Family family;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
