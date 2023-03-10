package com.lokesh.webfluxdemo.controller;

import com.lokesh.webfluxdemo.model.Employee;
import com.lokesh.webfluxdemo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
//    private final EmployeeRepository employeeRepository;
//
//    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    @GetMapping("/{id}")
//    private Mono<Employee> getEmployeeById(@PathVariable String id) {
//        return employeeRepository.findEmployeeById(id);
//    }
//
//    @GetMapping
//    private Flux<Employee> getAllEmployees() {
//        return employeeRepository.findAllEmployees();
//    }
}
