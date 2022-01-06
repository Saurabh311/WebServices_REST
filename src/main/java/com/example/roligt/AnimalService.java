package com.example.roligt;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class AnimalService {



    public Stream<AnimalEntity> all() {
        return Stream.of(
                new AnimalEntity(UUID.randomUUID().toString(),"Tiger", "x", "", ""),
                new AnimalEntity(UUID.randomUUID().toString(),"Zebra", "y", "", "")
        );
    }

    public AnimalEntity createAnimal(String name, String binomialName) {
        return new AnimalEntity(UUID.randomUUID().toString(), name, binomialName, "", "");
    }

    public AnimalEntity get(String id) {
        return new AnimalEntity(id, "Elephant", "BB", "", "");
    }

    public AnimalEntity update(String id, String name, String binomialName) {
        return new AnimalEntity(id, name, binomialName, "", "");
    }

    public void delete(String id) {
    }
}
