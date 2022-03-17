package com.evgeniy.springcourse;

import com.evgeniy.springcourse.component.withAfterReturningAdvice.Student;
import com.evgeniy.springcourse.component.withAfterReturningAdvice.University;
import com.evgeniy.springcourse.config.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestAfterThrowing {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        University university = context.getBean("university", University.class);
        try {
            List<Student> students = university.getStudentsWithException();
            System.out.println(students);
        } catch (Exception e) {
            System.err.println(e);
        }

        context.close();
    }
}
