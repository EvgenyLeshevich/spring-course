package com.evgeniy.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInitAndDestroy {
    public static void main(String[] args) {
        //prototype
        //destroy method не будет вызван

        ClassPathXmlApplicationContext contextWithScopePrototype =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Cat cat1 = contextWithScopePrototype.getBean("myPet", Cat.class);
        Cat cat2 = contextWithScopePrototype.getBean("myPet", Cat.class);

        contextWithScopePrototype.close();

        System.out.println("------------------------------------------");

        //singleton
        //destroy method будет вызван

        ClassPathXmlApplicationContext contextWithScopeSingleton =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        Cat cat3 = contextWithScopeSingleton.getBean("myPet", Cat.class);
        Cat cat4 = contextWithScopeSingleton.getBean("myPet", Cat.class);

        contextWithScopeSingleton.close();
    }
}
