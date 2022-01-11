package com.example.roligt;

public class AnimalNotFoundException extends Exception{

    public AnimalNotFoundException(String id){
        super(id);
    }
}
