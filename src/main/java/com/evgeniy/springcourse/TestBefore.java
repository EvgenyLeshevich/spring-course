package com.evgeniy.springcourse;

import com.evgeniy.springcourse.component.withBeforeAdvice.Book;
import com.evgeniy.springcourse.component.withBeforeAdvice.UniversityLibrary;
import com.evgeniy.springcourse.config.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBefore {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        UniversityLibrary universityLibrary = context.getBean("universityLibrary", UniversityLibrary.class);
        Book book = context.getBean("book", Book.class);
        universityLibrary.getBook();
        universityLibrary.getMagazine();
        universityLibrary.addBook("Evgeniy", book);
        universityLibrary.addMagazine();
//        universityLibrary.returnBook();
//        universityLibrary.returnMagazine();

/*        System.out.println("------------------------------------");

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();*/

        context.close();
    }
}
