package com.evgeniy.springcourse;

import com.evgeniy.springcourse.component.withBeforeAdvice.UniversityLibrary;
import com.evgeniy.springcourse.config.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAround {
    public static void main(String[] args) {
        System.out.println("Method main starts");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        UniversityLibrary universityLibrary = context.getBean("universityLibrary", UniversityLibrary.class);
        /*String bookName = universityLibrary.returnBookWithAround();
        System.out.println("В библиотеку вернули книгу " + bookName);*/

        String bookName = universityLibrary.returnBookWithAroundWithException();
        System.out.println("В библиотеку вернули книгу " + bookName);

        context.close();
        System.out.println("Method main ends");
    }
}
