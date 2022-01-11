package com.example.roligt;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Animal> update(@PathVariable String id, @RequestBody UpdateAnimal animal){
        try {
            return ResponseEntity.ok(toDTO(animalService.update(id, animal.getName(), animal.getBinomialName())));
        } catch (AnimalNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Animal> all(){
        return animalService.all()
                .map(AnimalController::toDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        try {
            animalService.delete(id);
            return ResponseEntity.ok().build();
        } catch (AnimalNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> get(@PathVariable("id") String id){
        try {
            return ResponseEntity.ok(toDTO(animalService.get(id)));
        } catch (AnimalNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/link/{remoteId}")
    public ResponseEntity<Animal> link(@PathVariable String id, @PathVariable String remoteId){
        try {
            return ResponseEntity.ok(toDTO(animalService.link(id, remoteId)));
        } catch (AnimalNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
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

