package com.lokesh.webfluxdemo.sampledata;

import com.lokesh.webfluxdemo.model.Animal;
import com.lokesh.webfluxdemo.repository.AnimalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class DataIntializer implements CommandLineRunner {
    private final AnimalRepository animalRepository;

    public DataIntializer(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    @Override
    public void run(String[] args) {
        log.info("start data initialization...");
        this.animalRepository
                .deleteAll()
                .thenMany(
                        Flux.just("Cat", "Dog", "Horse", "Cow")
                                .flatMap(
                                        name -> this.animalRepository.save(Animal.builder().name(name).kingdom("Vertebrate").build())
                                )
                )
                .log()
                .subscribe(
                        null,
                        null,
                        () -> log.info("done initialization...")
                );
    }
}
