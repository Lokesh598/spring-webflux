package com.lokesh.webfluxdemo.controller;

import com.lokesh.webfluxdemo.model.Animal;
import com.lokesh.webfluxdemo.repository.AnimalRepository;
import com.lokesh.webfluxdemo.resource.AnimalResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/animal")
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<AnimalResource> findAll() {
        return animalRepository.findAll()
                .map(AnimalResource::new)
                .delayElements(Duration.ofSeconds(1L));
    }
}
