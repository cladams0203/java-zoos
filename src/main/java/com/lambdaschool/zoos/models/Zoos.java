package com.lambdaschool.zoos.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "zoos")
public class Zoos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    private String zooname;

    @OneToMany(mappedBy = "zoo" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo")
    private Set<ZooAnimals> animals = new HashSet<>();

    public Zoos() {
    }

    public Zoos(long zooid, String zooname) {
        this.zooid = zooid;
        this.zooname = zooname;
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }
}
