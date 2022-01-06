package com.example.roligt;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("api/animals")
@AllArgsConstructor
public class AnimalController {

    AnimalService animalService;

    @PostMapping
    public Animal createAnimal(@RequestBody CreateAnimal createAnimal){
        return toDTO(animalService.createAnimal(createAnimal.getName(), createAnimal.getBinomialName()));
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable String id, @RequestBody UpdateAnimal animal){
        return toDTO(animalService.update(id, animal.getName(), animal.getBinomialName()));
    }

    @GetMapping
    public List<Animal> all(){
        return animalService.all()
                .map(AnimalController::toDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        animalService.delete(id);

    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable("id") String id){
        return toDTO(animalService.get(id));
    }


    private static Animal toDTO(AnimalEntity animalEntity) {
        return new Animal(
                animalEntity.getId(),
                animalEntity.getName(),
                animalEntity.getBinomialName(),
                animalEntity.getDescription(),
                animalEntity.getConservationStatus()
        );
    }
}

