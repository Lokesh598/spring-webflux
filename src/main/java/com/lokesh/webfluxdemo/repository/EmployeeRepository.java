package com.lokesh.webfluxdemo.repository;

import com.lokesh.webfluxdemo.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmployeeRepository {
    public Mono<Employee> findEmployeeById(String id) {
        return null;
    }

    public Flux<Employee> findAllEmployees() {
        return null;
    }
}
