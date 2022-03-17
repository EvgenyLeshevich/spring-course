package com.evgeniy.springcourse.aspect.withAfterThrowingAdvice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UniversityLoggingAspectWithException {

    // Мы можем поймать тут исключение из таргет-метода, но не можем его здесь обработать,
    // оно всё равно попадёт в таргет-метод и если мы его там не обработаем то программа не завершится/продолжится
    @AfterThrowing(pointcut = "execution(* getStudentsWithException())",
            throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения = " + exception);
    }
}
