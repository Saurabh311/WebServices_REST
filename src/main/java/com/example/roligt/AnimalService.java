package com.example.roligt;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AnimalService {

    AnimalRepository animalRepository;

    public Stream<AnimalEntity> all() {
        return animalRepository.all();
    }

    public AnimalEntity createAnimal(String name, String binomialName) {
        AnimalEntity animalEntity = new AnimalEntity(UUID.randomUUID().toString(), name, binomialName, "", "");
        return AnimalRepository.save(animalEntity);
    }

    public AnimalEntity get(String id) {
        return animalRepository.get(id);
    }

    public AnimalEntity update(String id, String name, String binomialName) {
        AnimalEntity animalEntity = animalRepository.get(id);
        animalEntity.setName(name);
        animalEntity.setBinomialName(binomialName);
        return animalRepository.save(animalEntity);
    }

    public void delete(String id) {
        AnimalEntity animalEntity = animalRepository.get(id);
        animalRepository.delete(animalEntity);

    }
}
