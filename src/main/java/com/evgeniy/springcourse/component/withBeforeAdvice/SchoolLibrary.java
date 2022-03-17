package com.evgeniy.springcourse.component.withBeforeAdvice;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("Берём книгу из SchoolLibrary");
    }
}
