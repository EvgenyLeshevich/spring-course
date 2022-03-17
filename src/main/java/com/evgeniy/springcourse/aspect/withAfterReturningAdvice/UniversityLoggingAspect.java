package com.evgeniy.springcourse.aspect.withAfterReturningAdvice;

import com.evgeniy.springcourse.component.withAfterReturningAdvice.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение" +
                " списка студентов перед методом getStudents()");
    }

    // С изменением значений после отработки таргет-метода,
    // изменяется значение в случае присвоения результата другой переменной
    @AfterReturning(pointcut = "execution(* getStudents())",
            returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
        Student firstStudent = students.get(0);

        String name = firstStudent.getName();
        name = "Mr. " + name;
        firstStudent.setName(name);

        double avgGrade = firstStudent.getAvgGrade();
        avgGrade = avgGrade + 1;
        firstStudent.setAvgGrade(avgGrade);

        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение" +
                " списка студентов после работы метода getStudents()");
    }

    // Без изменения значений после отработки таргет-метода
/*    @AfterReturning("execution(* getStudents())")
    public void afterReturningGetStudentsLoggingAdvice(){
        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение" +
                " списка студентов после работы метода getStudents()");
    }*/
}
