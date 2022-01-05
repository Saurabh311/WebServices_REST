package com.example.roligt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("api/animals")
public class AnimalController {

    private final List<Animal> animals;

    public AnimalController() {
        this.animals = List.of(
                new Animal("Tiger"),
                new Animal("Zebra")
        );
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

