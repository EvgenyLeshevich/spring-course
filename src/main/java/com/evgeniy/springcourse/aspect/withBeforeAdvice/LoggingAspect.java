package com.evgeniy.springcourse.aspect.withBeforeAdvice;

import com.evgeniy.springcourse.component.withBeforeAdvice.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

/*    @Pointcut("execution(* com.evgeniy.springcourse.component.withBeforeAdvice.UniversityLibrary.*(..))")
    public void allMethodsFromUniversityLibrary(){}

    @Pointcut("execution(public void com.evgeniy.springcourse.component.withBeforeAdvice.UniversityLibrary.returnMagazine())")
    public void returnMagazineFromUniversityLibrary(){}

    @Pointcut("allMethodsFromUniversityLibrary() && !returnMagazineFromUniversityLibrary()")
    public void allMethodsExceptReturnMagazineFromUniversityLibrary(){}

    @Before("allMethodsExceptReturnMagazineFromUniversityLibrary()")
    public void beforeAllMethodsExceptReturnMagazineAdvice(){
        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log #10");
    }*/

/*    @Pointcut("execution(* com.evgeniy.springcourse.component.withBeforeAdvice.UniversityLibrary.get*())")
    private void allGetMethodsFromUniversityLibrary(){}

    @Pointcut("execution(* com.evgeniy.springcourse.component.withBeforeAdvice.UniversityLibrary.return*())")
    private void allReturnMethodsFromUniversityLibrary(){}

    @Pointcut("allGetMethodsFromUniversityLibrary() || allReturnMethodsFromUniversityLibrary()")
    private void allGetAndReturnMethodsFromUniversityLibrary(){}

    @Before("allGetMethodsFromUniversityLibrary()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: writing Log #1");
    }

    @Before("allReturnMethodsFromUniversityLibrary()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
    }

    @Before("allGetAndReturnMethodsFromUniversityLibrary()")
    public void beforeGetAndReturnLoggingAdvice(){
        System.out.println("beforeReturnLoggingAdvice: writing Log #3");
    }*/

    @Before("com.evgeniy.springcourse.aspect.withBeforeAdvice.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] objects = joinPoint.getArgs();
            for (Object o :
                    objects) {
                if (o instanceof Book) {
                    Book book = (Book) o;
                    System.out.println("Информация о книге: название - " + book.getName() +
                            ", автор - " + book.getAuthor() +
                            ", год издания - " + book.getYearOfPublication());
                } else if (o instanceof String) {
                    System.out.println("Книгу в библиотеку добавил: " + o);
                }
            }
        }

        System.out.println("beforeAddLoggingAdvice: логирование попытки получить книгу/журнал");
        System.out.println("-----------------------------------------------------");
    }

/*    @Before("execution(public void com.evgeniy.springcourse.component.withBeforeAdvice.UniversityLibrary.getBook())")
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }*/

/*    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
    }*/

/*    @Before("execution(public void getBook(com.evgeniy.springcourse.component.withBeforeAdvice.Book, ..))")
    public void beforeGetBookWithNameAdvice(){
        System.out.println("beforeGetBookWithNameAdvice:
        сработает для метода getBook где первый параметр Book и далее любое количество параметров");
    }*/

/*    @Before("execution(* *())")
    public void beforeAdvice(){
        System.out.println("beforeAdvice: сработает для всех методов без параметров и с любым модификатором");
    }*/

/*    @Before("execution(public void get*())")
    public void beforeGetAdvice(){
        System.out.println("beforeGetAdvice: сработает для всех методов начинающихся с get без параметров");
    }*/


}
