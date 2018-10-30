package com.stala.family;

import com.stala.family.model.Child;
import com.stala.family.model.Family;
import com.stala.family.model.Father;
import com.stala.family.model.Sex;
import com.stala.family.service.ChildService;
import com.stala.family.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class FamilyApplication implements CommandLineRunner {

    @Autowired
    private ChildService childService;
    @Autowired
    private FamilyService familyService;

    public static void main(String[] args) {
        SpringApplication.run(FamilyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Family family = familyService.createFamily();
//        Father father = new Father();
//        father.setFirstName("Jan");
//        father.setSecondName("Borowiak");
//        father.setBirthDate(new Date());
//        father.setPesel("21312312");
//        familyService.addFatherToFamily(family.getId(), father);
//        Child child = new Child();
//        child.setFirstName("Jan");
//        child.setSecondName("Kowalski");
//        child.setSex(Sex.MALE);
//        child.setPesel("1111");
//        child.setFamily(family);
//        familyService.addChildToFamily(family.getId(), child);
//        Child child1 = new Child();
//        child1.setFirstName("Anna");
//        child1.setSecondName("Jakubiak");
//        child1.setSex(Sex.FEMALE);
//        child1.setPesel("2222");
//        child1.setFamily(family);
//        familyService.addChildToFamily(family.getId(),child1);
//        Child child2 = new Child();
//        child2.setFirstName("Mrek");
//        child2.setSecondName("Kowalski");
//        child2.setSex(Sex.MALE);
//        child2.setPesel("33333");
//        child2.setFamily(family);
//        familyService.addChildToFamily(family.getId(),child2);
//
//
//        Family family1 = familyService.createFamily();
//        Father father1 = new Father();
//        father1.setFirstName("Grzegorz");
//        father1.setSecondName("Stala");
//        father1.setBirthDate(new Date());
//        father1.setPesel("43343");
//        familyService.addFatherToFamily(family1.getId(),father1);
//        Child child3 = new Child();
//        child3.setFirstName("Maksymilian");
//        child3.setSecondName("Stala");
//        child3.setSex(Sex.MALE);
//        child3.setPesel("3456777");
//        child3.setFamily(family1);
//        familyService.addChildToFamily(family1.getId(),child3);
//
//        System.out.println(childService.searchChild("","Stala", "", null).size());
    }
}
