package com.lokesh.webfluxdemo.controller;

import com.lokesh.webfluxdemo.config.MongoConfig;
import com.lokesh.webfluxdemo.model.Animal;
import com.lokesh.webfluxdemo.repository.AnimalRepository;
import com.lokesh.webfluxdemo.resource.AnimalResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/animal")
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<AnimalResource> findAll() {
        return animalRepository.findAll()
                .map(AnimalResource::new)
                .delayElements(Duration.ofSeconds(1L));
    }

    @GetMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public Mono<AnimalResource> findAnimalById(@PathVariable("id") String id) {
        return animalRepository.findById(id)
                .map(AnimalResource::new)
                .delayElement(Duration.ofSeconds(1L));
    }
}
