package com.evgeniy.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
    public static void main(String[] args) {

        //prototype

        ClassPathXmlApplicationContext contextWithScopePrototype =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Cat cat1 = contextWithScopePrototype.getBean("myPet", Cat.class);
        cat1.setName("Vasya");
        Cat cat2 = contextWithScopePrototype.getBean("myPet", Cat.class);
        cat2.setName("Murka");

        System.out.println("Cat1 and cat2 it's a once object? " +
                (cat1==cat2));
        System.out.println(cat1.getName());
        System.out.println(cat2.getName());

        contextWithScopePrototype.close();

        System.out.println("------------------------------------------");

        //singleton

        ClassPathXmlApplicationContext contextWithScopeSingleton =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        Cat cat3 = contextWithScopeSingleton.getBean("myPet", Cat.class);
        cat3.setName("Vasya");
        Cat cat4 = contextWithScopeSingleton.getBean("myPet", Cat.class);
        cat4.setName("Murka");

        System.out.println("Cat3 and cat4 it's a once object? " +
                (cat3==cat4));
        System.out.println(cat3.getName());
        System.out.println(cat4.getName());

        contextWithScopeSingleton.close();
    }
}
