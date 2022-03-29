package com.evgeniy.model;

import com.evgeniy.validation.CheckEmail;
import lombok.*;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Employee {

    @Size(min = 2, message = "name must by min 2 symbols")
    private String name;
    @NotBlank(message = "surname is required field")
    private String surname;
    @Min(value = 700, message = "must be greater than 699")
    @Max(value = 9000, message = "must be less than 9001")
    private int salary;
    private String department;
    private Map<String, String> departmentMap;
    private String carBrand;
    private Map<String, String> carBrandMap;
    private List<String> languages;
    private Map<String, String> languageMap;
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "Please use pattern XXX-XX-XX")
    private String phoneNumber;
    @CheckEmail(value = "abc.com", message = "email must ends with abc.com")
    private String email;

    {
        departmentMap = new HashMap<>();
        departmentMap.put("Information Technology", "IT");
        departmentMap.put("Human Resources", "HR");
        departmentMap.put("Sales", "Sales");

        carBrandMap = new HashMap<>();
        carBrandMap.put("BMW", "BMW");
        carBrandMap.put("Audi", "Audi");
        carBrandMap.put("Mercedes-Benz", "MB");

        languageMap = new HashMap<>();
        languageMap.put("English", "EN");
        languageMap.put("Deutch", "DE");
        languageMap.put("French", "FR");
    }
}
