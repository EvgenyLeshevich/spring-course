package com.evgeniy.springcourse;

import com.evgeniy.springcourse.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Cat cat1 = context.getBean("cat", Cat.class);
        cat1.setName("Vasya");
        Cat cat2 = context.getBean("cat", Cat.class);
        cat2.setName("Murka");

        System.out.println("Cat1 and cat2 it's a once object? " +
                (cat1==cat2));
        System.out.println(cat1.getName());
        System.out.println(cat2.getName());

        context.close();
    }
}
