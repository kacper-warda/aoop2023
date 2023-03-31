package com.example.wsbaoop.mobilezoo;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    public static List<Animal> savedAnimals = new ArrayList<>();

    public String specie;
    public String name;
    public Boolean alive;

    public Animal(String specie, String name, Boolean alive) {
        this.specie = specie;
        this.name = name;
        this.alive = alive;
    }

    public Animal() {
    }


    @Override
    public String toString() {
        return "Animal{" +
                "specie='" + specie + '\'' +
                ", name='" + name + '\'' +
                ", alive=" + alive +
                '}';
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
}
