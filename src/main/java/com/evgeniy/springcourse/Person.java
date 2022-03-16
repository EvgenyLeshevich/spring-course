package com.evgeniy.springcourse;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = {"name", "age"})
public class Person {
    private Pet pet;
    private String name;
    private Integer age;

    public Person() {
        System.out.println("Person bean is created");
    }

    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Hello, my Pet!");
        pet.say();
    }
}
