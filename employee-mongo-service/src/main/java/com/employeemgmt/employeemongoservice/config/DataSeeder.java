package com.employeemgmt.employeemongoservice.config;

import com.employeemgmt.employeemongoservice.model.Employee;
import com.employeemgmt.employeemongoservice.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedEmployees(EmployeeRepository employeeRepository) {
        return args -> {
            if (employeeRepository.count() == 0) {
                employeeRepository.saveAll(java.util.List.of(
                        new Employee("Alice Johnson", "alice.johnson@example.com", "Engineering"),
                        new Employee("Bob Smith", "bob.smith@example.com", "Sales"),
                        new Employee("Carol Davis", "carol.davis@example.com", "Marketing")
                ));
            }
        };
    }
}
