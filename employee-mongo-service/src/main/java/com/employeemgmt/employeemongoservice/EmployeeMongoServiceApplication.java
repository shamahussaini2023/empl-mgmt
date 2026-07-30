package com.employeemgmt.employeemongoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeMongoServiceApplication {
//http://localhost:8083/api/mongo/employees
    public static void main(String[] args) {
        SpringApplication.run(EmployeeMongoServiceApplication.class, args);
    }
}
