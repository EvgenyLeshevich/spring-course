package com.evgeniy.springcourse;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet {

    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("Gav-gav!");
    }
}
