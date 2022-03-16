package com.evgeniy.springcourse;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString(of = {"name", "age"})
@Component
public class Person {
    @Autowired
    @Qualifier("dog")
    private Pet pet;
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private Integer age;

    public Person() {
        System.out.println("Person bean is created");
    }

    public void callYourPet() {
        System.out.println("Hello, my Pet!");
        pet.say();
    }
}
