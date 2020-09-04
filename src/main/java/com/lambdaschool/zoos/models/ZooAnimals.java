package com.lambdaschool.zoos.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimals.class)
public class ZooAnimals extends Auditable implements Serializable {

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


//    private String incomingzoo;

    public ZooAnimals() {
    }

//    public ZooAnimals(Zoos zoo, Animals animal, String incomingzoo) {
//        this.zoo = zoo;
//        this.animal = animal;
//        this.incomingzoo = incomingzoo;
//    }

    public ZooAnimals(Zoos zoo, Animals animal) {
        this.zoo = zoo;
        this.animal = animal;
//        this.incomingzoo = null;
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

//    public String getIncomingzoo() {
//        return incomingzoo;
//    }
//
//    public void setIncomingzoo(String incomingzoo) {
//        this.incomingzoo = incomingzoo;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooAnimals that = (ZooAnimals) o;
        return ((this.zoo == null) ? 0 : this.getZoo().getZooid()) == ((that.zoo == null) ? 0 : that.getZoo().getZooid()) &&
                ((this.animal == null) ? 0 : this.getAnimal().getAnimalid()) == ((that.animal == null) ? 0 : that.getAnimal().getAnimalid());
    }

    @Override
    public int hashCode() {
        return 37;
    }
}
