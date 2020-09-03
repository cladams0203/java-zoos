package com.lambdaschool.zoos.models;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ZooAnimalsId implements Serializable {

    private long animal;

    private long zoo;

    public ZooAnimalsId() {
    }

    public long getAnimal() {
        return animal;
    }

    public void setAnimal(long animal) {
        this.animal = animal;
    }

    public long getZoo() {
        return zoo;
    }

    public void setZoo(long zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooAnimalsId that = (ZooAnimalsId) o;
        return this.animal == that.animal &&
                this.zoo == that.zoo;
    }

    @Override
    public int hashCode() {
        return 37;
    }
}
