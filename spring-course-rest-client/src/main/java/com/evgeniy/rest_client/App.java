package com.evgeniy.rest_client;

import com.evgeniy.rest_client.config.ApplicationConfiguration;
import com.evgeniy.rest_client.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        Communication communication = context.getBean("communication", Communication.class);

        // Get some info from yandex weather api
//        Weather yandexApiWeather = communication.yandexWeather();

        // Get all employees
        List<Employee> allEmployee = communication.getAllEmployee();
        System.out.println(allEmployee);

        // Get one employee by ID
//        Employee employeeByID = communication.getEmployee(1L);
//        System.out.println(employeeByID);

        // Save employee
//        Employee employeeForAdd = Employee.builder()
//                .name("Sasha")
//                .surname("S")
//                .department("IT")
//                .salary(1500)
//                .build();
//        communication.saveEmployee(employeeForAdd);

        // Update Employee
//        Employee employeeForUpdate = Employee.builder()
//                .id(8L)
//                .name("Sasha")
//                .surname("S")
//                .department("IT")
//                .salary(2000)
//                .build();
//        communication.saveEmployee(employeeForUpdate);

        //Delete employee
//        communication.deleteEmployee(8L);
    }
}
