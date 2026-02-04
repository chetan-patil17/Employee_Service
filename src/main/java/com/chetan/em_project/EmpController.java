package com.chetan.em_project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    // 🔹 GET ALL
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }

    // 🔹 GET BY ID
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    // 🔹 CREATE
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // 🔹 DELETE
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable long id) {
        if (employeeService.deleteEmployee(id)) {
            return "Employee deleted successfully";
        }
        return "Employee deletion failed";
    }

    // 🔹 UPDATE
    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
}