package com.employeemgmt.employeeservice.repository;

import com.employeemgmt.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
