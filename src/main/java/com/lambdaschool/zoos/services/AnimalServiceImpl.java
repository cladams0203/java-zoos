package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animals;
import com.lambdaschool.zoos.models.ZooAnimals;
import com.lambdaschool.zoos.models.Zoos;
import com.lambdaschool.zoos.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalrepos;

    @Autowired
    private ZooService zooService;

    @Transactional
    @Override
    public Animals save(Animals animal) {
        Animals newAnimal = new Animals();
        if(animal.getAnimalid() != 0){
            animalrepos.findById(animal.getAnimalid())
                    .orElseThrow(() -> new EntityNotFoundException("Animal " + animal.getAnimalid() + " not found"));
            newAnimal.setAnimalid(animal.getAnimalid());
        }
        newAnimal.setAnimaltype(animal.getAnimaltype());
        newAnimal.getZoos().clear();
        for(ZooAnimals z : animal.getZoos()){
            Zoos newZoo = zooService.findByZooId(z.getZoo().getZooid());
            newAnimal.getZoos().add(new ZooAnimals(newZoo, newAnimal));
        }
        return animalrepos.save(newAnimal);
    }
}
