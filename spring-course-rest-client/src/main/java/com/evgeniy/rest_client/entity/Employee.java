package com.evgeniy.rest_client.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"name", "surname"})
@ToString
@Builder
public class Employee {

    private Long id;

    private String name;

    private String surname;

    private String department;

    private int salary;
}
