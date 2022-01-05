package com.example.roligt;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("api/animals")
public class AnimalController {

    private final List<Animal> animals;

    public AnimalController() {
        this.animals = List.of(
                new Animal(UUID.randomUUID().toString(),"Tiger", "x", "", ""),
                new Animal(UUID.randomUUID().toString(),"Zebra", "y", "", "")
        );
    }

    @PostMapping
    public Animal createAnimal(@RequestBody CreateAnimal createAnimal){
        return new Animal(UUID.randomUUID().toString(),createAnimal.getName(), createAnimal.getBinomialName(), "", "");
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable String id, @RequestBody UpdateAnimal animal){
        return new Animal(id, animal.getName(), animal.getBinomialName(), "", "");
    }

    @GetMapping
    public List<Animal> all(){
        return animals;
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable("id") String id){
        return animals.stream()
                .filter(animal -> animal.getId()
                .equals(id))
                .findAny()
                .orElse(null);
    }
}

