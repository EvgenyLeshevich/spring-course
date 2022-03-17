package com.evgeniy.springcourse.component.withBeforeAdvice;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary {

    private void line() {
        System.out.println("-----------------------------------------------------");
    }

    @Override
    public void getBook() {
        System.out.println("Берём книгу из UniversityLibrary");
        line();
    }

    public void returnBook() {
        System.out.println("Возвращаем книгу в UniversityLibrary");
        line();
    }

    public void getMagazine() {
        System.out.println("Берём журнал из UniversityLibrary");
        line();
    }

    public void returnMagazine() {
        System.out.println("Возвращаем журнал в UniversityLibrary");
        line();
    }

    public void addBook(String personName, Book book) {
        System.out.println("Добавляем книгу в UniversityLibrary");
        line();
    }

    public void addMagazine() {
        System.out.println("Добавляем журнал в UniversityLibrary");
        line();
    }

    /*    public void getBook(Book book){
        System.out.println("Берём книгу из UniversityLibrary " + book.getName());
    }*/

    public String returnBookWithAround() {
        System.out.println("Возвращаем книгу в UniversityLibrary");
        return "Война и мир";
    }

    public String returnBookWithAroundWithException() {
        int result = 10 / 0;
        System.out.println("Возвращаем книгу в UniversityLibrary");
        return "Война и мир";
    }
}
