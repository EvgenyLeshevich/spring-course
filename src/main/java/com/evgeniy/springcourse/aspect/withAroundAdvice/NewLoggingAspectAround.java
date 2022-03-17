package com.evgeniy.springcourse.aspect.withAroundAdvice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspectAround {

    @Around("execution(public String returnBookWithAround())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        long begin = System.currentTimeMillis();
        Object targetMethodResult = proceedingJoinPoint.proceed(); // Здесь получаем результат работы метода returnBookWithAround
        // И можем его изменить
        targetMethodResult = "Изменил";
        long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
        System.out.println("aroundReturnBookLoggingAdvice: метод returnBookWithAround отработал за " +
                (end - begin) + " миллисекунд");
        return targetMethodResult;
    }

    // Можем ничего не делать с исключением
    // Можем его здесь обработать (но лучше так не делать, так ка мы здесь обработаем это исключение,
    // а в главном методе не будет известно, что вообще было и где было обработка
    // Можем сделать какие-то действия и пробросить исключение дальше (лучше всего делать так)
    @Around("execution(public String returnBookWithAroundWithException())")
    public Object aroundReturnBookWithExceptionLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundReturnBookWithExceptionLoggingAdvice: логируем исключение " + e);
            throw e; // Здесь пробрасываем исключение дальше в метод где мы вызвали метод returnBookWithAroundWithException
        }

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
        return targetMethodResult;
    }
}
