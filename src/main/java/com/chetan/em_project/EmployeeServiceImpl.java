package com.chetan.em_project;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    // 🔹 CREATE
    @Override
    public Employee createEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        logger.info("Employee added successfully with ID: {}", savedEmployee.getId());
        return savedEmployee;
    }

    // 🔹 READ ALL
    @Override
    public List<Employee> readEmployees() {
        return employeeRepository.findAll();
    }

    // 🔹 READ BY ID
    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // 🔹 UPDATE
    @Override
    public String updateEmployee(long id, Employee employee) {
        return employeeRepository.findById(id)
                .map(existingEmployee -> {
                    existingEmployee.setName(employee.getName());
                    existingEmployee.setPhone(employee.getPhone());
                    existingEmployee.setEmail(employee.getEmail());

                    employeeRepository.save(existingEmployee);

                    logger.info("Employee updated successfully with ID: {}", id);
                    return "Employee updated successfully";
                })
                .orElse("Employee not found");
    }

    // 🔹 DELETE
    @Override
    public boolean deleteEmployee(long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            logger.info("Employee deleted successfully with ID: {}", id);
            return true;
        }
        logger.warn("Employee deletion failed. ID not found: {}", id);
        return false;
    }
}
