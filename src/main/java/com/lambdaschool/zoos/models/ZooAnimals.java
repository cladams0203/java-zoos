package com.lambdaschool.zoos.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "zooanimals")
public class ZooAnimals {

    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = "animals")
    @JoinColumn(name = "zooid")
    private Zoos zoo;

    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = "zoos")
    @JoinColumn(name = "animalid")
    private Animals animal;

    public ZooAnimals() {
    }

    public ZooAnimals(Zoos zoo, Animals animal) {
        this.zoo = zoo;
        this.animal = animal;
    }

    public Zoos getZoo() {
        return zoo;
    }

    public void setZoo(Zoos zoo) {
        this.zoo = zoo;
    }

    public Animals getAnimal() {
        return animal;
    }

    public void setAnimal(Animals animal) {
        this.animal = animal;
    }
}
