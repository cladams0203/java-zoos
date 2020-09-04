package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animals;
import com.lambdaschool.zoos.models.ZooAnimals;
import com.lambdaschool.zoos.models.Zoos;
import com.lambdaschool.zoos.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "roleService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalrepos;

    @Autowired
    private ZooService zooService;

    @Transactional
    @Override
    public Animals save(Animals animal) {
        if(animal.getZoos().size() > 0){
            throw new EntityNotFoundException("Zoos are not updated through animals");
        }
        return animalrepos.save(animal);

    }

    @Override
    public Animals findByAnimalId(long id) {
        return animalrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal " + id + " Not Found"));
    }
}
