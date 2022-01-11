package com.example.roligt;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class AnimalRepository {

    Map<String,AnimalEntity> animals = new HashMap<>();

    public AnimalEntity save(AnimalEntity animalEntity) {
        animals.put(animalEntity.getId(), animalEntity);
        return animalEntity;
    }

    public Stream<AnimalEntity> all() {
        return animals.values().stream();
    }

    public Optional<AnimalEntity> get(String id) {
        return Optional.ofNullable(animals.get(id));
    }

    public void delete(AnimalEntity animalEntity) {
        animals.remove(animalEntity.getId());
    }
}
