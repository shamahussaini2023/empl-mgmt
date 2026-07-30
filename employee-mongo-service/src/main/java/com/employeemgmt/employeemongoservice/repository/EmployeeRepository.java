package com.employeemgmt.employeemongoservice.repository;

import com.employeemgmt.employeemongoservice.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByDepartment(String department);
}
