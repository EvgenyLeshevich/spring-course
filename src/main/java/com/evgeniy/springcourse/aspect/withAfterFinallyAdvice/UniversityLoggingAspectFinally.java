package com.evgeniy.springcourse.aspect.withAfterFinallyAdvice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UniversityLoggingAspectFinally {

    @After("execution(* getStudentsFinally())")
    public void afterGetStudentsFinallyAdvice() {
        System.out.println("afterGetStudentsFinallyAdvice: логируем нормальное" +
                " завершение работы метода или выброс исключения");
    }
}
