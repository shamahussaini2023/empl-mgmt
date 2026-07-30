package com.employeemgmt.employeeservice.service;

import com.employeemgmt.employeeservice.exception.EmployeeNotFoundException;
import com.employeemgmt.employeeservice.model.Employee;
import com.employeemgmt.employeeservice.repository.EmployeeRepository;
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

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updated) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(updated.getName());
                    employee.setEmail(updated.getEmail());
                    employee.setDepartment(updated.getDepartment());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
