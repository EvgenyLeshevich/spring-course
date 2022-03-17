package com.evgeniy.springcourse.component.withAfterReturningAdvice;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private final List<Student> students;

    {
        students = new ArrayList<>();

        Student st1 = new Student("Evgeniy Leshevich", 3, 5.1);
        Student st2 = new Student("Nina Leshevich", 5, 9.2);
        Student st3 = new Student("Ivan Sidorov", 3, 4.5);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents() {
        System.out.println("Information from method getStudents: ");
        System.out.println(students);
        return students;
    }

    public List<Student> getStudentsWithException() {
        System.out.println("Начало метода getStudentsWithException");
        System.out.println(students.get(5));
        System.out.println("Information from method getStudentsWithException: ");
        System.out.println(students);
        return students;
    }

    public List<Student> getStudentsFinally() {
        System.out.println("Information from method getStudentsFinally: ");
        System.out.println(students);
        return students;
    }
}
