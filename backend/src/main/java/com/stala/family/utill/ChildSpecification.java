package com.stala.family.utill;

import com.stala.family.model.Child;
import com.stala.family.model.Sex;
import org.springframework.data.jpa.domain.Specification;

public class ChildSpecification {

    public static Specification<Child> firstNameLike(String firstName) {
        return (child, cq, cb) -> cb.like(child.get("firstName"), "%" + firstName + "%");
    }

    public static Specification<Child> secondNameLike(String secondName) {
        return (child, cq, cb) -> cb.like(child.get("secondName"), "%" + secondName + "%");
    }

    public static Specification<Child> peselLike(String pesel) {
        return (child, cq, cb) -> cb.like(child.get("pesel"), "%" + pesel + "%");
    }

    public static Specification<Child> sexEquals(Sex sex) {
        return (child, cq, cb) -> cb.equal(child.get("sex"), sex);
    }
}
