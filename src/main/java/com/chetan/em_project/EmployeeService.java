package com.chetan.em_project;

import java.util.List;

public interface EmployeeService {

    // CREATE
    Employee createEmployee(Employee employee);

    // READ ALL
    List<Employee> readEmployees();

    // READ BY ID
    Employee getEmployeeById(long id);

    // UPDATE
    String updateEmployee(long id, Employee employee);

    // DELETE
    boolean deleteEmployee(long id);
}
