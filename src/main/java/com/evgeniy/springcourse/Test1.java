package com.evgeniy.springcourse;

import com.evgeniy.springcourse.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Person person = context.getBean("person", Person.class);
        person.callYourPet();

        System.out.println(person);

        context.close();
    }
}
