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
    JsonPlaceholderRemote jsonPlaceholderRemote;

    public Stream<AnimalEntity> all() {
        return animalRepository.all();
    }

    public AnimalEntity createAnimal(String name, String binomialName) {
        AnimalEntity animalEntity = new AnimalEntity(UUID.randomUUID().toString(), name, binomialName, "", "");
        return animalRepository.save(animalEntity);
    }

    public AnimalEntity get(String id) throws AnimalNotFoundException {
        return animalRepository.get(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
    }

    public AnimalEntity update(String id, String name, String binomialName) throws AnimalNotFoundException {
        AnimalEntity animalEntity = animalRepository.get(id)
                .orElseThrow(()-> new AnimalNotFoundException(id));
        animalEntity.setName(name);
        animalEntity.setBinomialName(binomialName);
        return animalRepository.save(animalEntity);
    }

    public void delete(String id) throws AnimalNotFoundException {
        AnimalEntity animalEntity = animalRepository.get(id)
                .orElseThrow(()->new AnimalNotFoundException(id));
        animalRepository.delete(animalEntity);

    }

    public AnimalEntity link(String id, String remoteId) throws AnimalNotFoundException{
        AnimalEntity animalEntity = animalRepository.get(id)
                .orElseThrow(()-> new AnimalNotFoundException(id));
        JsonPlaceholderRemote.JsonPlaceholder json = jsonPlaceholderRemote.get(remoteId);
        animalEntity.setDescription(json.getBody());
        return animalRepository.save(animalEntity);
    }
}
