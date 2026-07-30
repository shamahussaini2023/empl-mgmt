package com.employeemgmt.employeemongoservice.service;

import com.employeemgmt.employeemongoservice.exception.EmployeeNotFoundException;
import com.employeemgmt.employeemongoservice.model.Employee;
import com.employeemgmt.employeemongoservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(String id, Employee updated) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(updated.getName());
                    employee.setEmail(updated.getEmail());
                    employee.setDepartment(updated.getDepartment());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
