package com.lambdaschool.zoos.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "telephones")
public class Telephones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    private String phonenumber;

    private String phonetype;

    @ManyToOne

    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "telephones", allowSetters = true)
    private Zoos zoo;

    public Telephones() {
    }

    public Telephones( String phonenumber, String phonetype, Zoos zoo) {

        this.phonenumber = phonenumber;
        this.phonetype = phonetype;
        this.zoo = zoo;
    }




    public long getPhoneid() {
        return phoneid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public Zoos getZoo() {
        return zoo;
    }

    public void setZoo(Zoos zoo) {
        this.zoo = zoo;
    }

}
