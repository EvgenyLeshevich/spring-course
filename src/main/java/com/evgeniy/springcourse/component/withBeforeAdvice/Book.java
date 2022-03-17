package com.evgeniy.springcourse.component.withBeforeAdvice;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Book {
    @Value("Атлант расправил плечи")
    private String name;
    @Value("Роман Айн Рэнд")
    private String author;
    @Value("1957")
    private int yearOfPublication;
}
