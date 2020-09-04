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

    private String incomingzoo;

    public ZooAnimals() {
    }

    public ZooAnimals(Zoos zoo, Animals animal, String incomingzoo) {
        this.zoo = zoo;
        this.animal = animal;
        this.incomingzoo = incomingzoo;
    }

    public ZooAnimals(Zoos zoo, Animals animal) {
        this.zoo = zoo;
        this.animal = animal;
        this.incomingzoo = null;
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

    public String getIncomingzoo() {
        return incomingzoo;
    }

    public void setIncomingzoo(String incomingzoo) {
        this.incomingzoo = incomingzoo;
    }

}
