package com.lokesh.webfluxdemo.webclient;

import com.lokesh.webfluxdemo.model.Employee;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmployeeWebClient {
        WebClient client = WebClient.create("http://localhost:8081");

    Mono<Employee> employeeMono = client.get()
            .uri("/employees/{id}", "1")
            .retrieve()
            .bodyToMono(Employee.class);

//    employeeMono.subscribe()

    Flux<Employee> employeeFlux = client.get()
            .uri("/employees")
            .retrieve()
            .bodyToFlux(Employee.class);

//    employeeFlux.subscribe(System.out::println);

}
