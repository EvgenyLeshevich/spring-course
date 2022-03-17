package com.evgeniy.springcourse.component.withAfterReturningAdvice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Student {
    private String name;
    private Integer course;
    private double avgGrade;
}
