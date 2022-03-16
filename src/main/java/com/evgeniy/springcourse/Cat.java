package com.evgeniy.springcourse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cat implements Pet {
    private String name;

    public Cat() {
        System.out.println("Cat bean is created");
    }

    private void init(){
        System.out.println("Doing my initialization method");
    }

    private void destroy(){
        System.out.println("Doing my destroy method");
    }

    @Override
    public void say() {
        System.out.println("Meow-meow!");
    }
}
