package com.evgeniy.springcourse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Setter
@Component
//@Scope("prototype")
public class Cat implements Pet {
    private String name;

    public Cat() {
        System.out.println("Cat bean is created");
    }

    @PostConstruct
    private void init(){
        System.out.println("Doing my initialization method");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("Doing my destroy method");
    }

    @Override
    public void say() {
        System.out.println("Meow-meow!");
    }
}
