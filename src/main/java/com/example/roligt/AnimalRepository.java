package com.example.roligt;

import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Stream;

@Component
public class AnimalRepository {
    public static AnimalEntity save(AnimalEntity animalEntity) {
        return animalEntity;
    }

    public Stream<AnimalEntity> all() {
        return Stream.of(
                new AnimalEntity(UUID.randomUUID().toString(),"Tiger", "x", "", ""),
                new AnimalEntity(UUID.randomUUID().toString(),"Zebra", "y", "", "")
        );
    }

    public AnimalEntity get(String id) {
        return new AnimalEntity(id, "Elephant", "BB", "", "");
    }

    public void delete(AnimalEntity animalEntity) {

    }
}
