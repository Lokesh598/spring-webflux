package com.lokesh.webfluxdemo.repository;

import com.lokesh.webfluxdemo.model.Animal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends ReactiveMongoRepository<Animal, String> {
}
