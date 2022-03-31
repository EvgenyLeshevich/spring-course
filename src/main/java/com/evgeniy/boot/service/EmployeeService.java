package com.evgeniy.boot.service;

import com.evgeniy.boot.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(Long id);

    void deleteEmployee(Long id);

    List<Employee> findAllEmployeesByName(String name);
}
