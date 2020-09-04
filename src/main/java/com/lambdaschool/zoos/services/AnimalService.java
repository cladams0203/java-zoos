package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animals;

import java.util.ArrayList;

public interface AnimalService {

    Animals save(Animals animal);

    Animals findByAnimalId(long id);
}
