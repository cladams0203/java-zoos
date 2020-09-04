package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animals;
import com.lambdaschool.zoos.models.Telephones;
import com.lambdaschool.zoos.models.ZooAnimals;
import com.lambdaschool.zoos.models.Zoos;
import com.lambdaschool.zoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "zooService")
public class ZooServiceImpl implements ZooService {

    @Autowired
    ZooRepository zoorepos;

    @Autowired
    AnimalService animalService;

    @Override
    public Zoos findByZooId(long id) {
        return zoorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo " + id + " Not Found"));
    }

    @Transactional
    @Override
    public Zoos save(Zoos zoo) {
        Zoos newZoo = new Zoos();

        if(zoo.getZooid() != 0){
            zoorepos.findById(zoo.getZooid())
                    .orElseThrow(() -> new EntityNotFoundException("Zoo " + zoo.getZooid() + " Not Found"));
            newZoo.setZooid(zoo.getZooid());
        }
        newZoo.setZooname(zoo.getZooname());
        newZoo.getAnimals().clear();
        for(ZooAnimals z : zoo.getAnimals()){
            Animals newAnimal = animalService.findByAnimalId(z.getAnimal().getAnimalid());
            newZoo.getAnimals().add(new ZooAnimals(newZoo, newAnimal));
        }
        newZoo.getPhones().clear();
        for (Telephones p : zoo.getPhones()){
            newZoo.getPhones().add(new Telephones(p.getPhonenumber(), p.getPhonetype(), newZoo));
        }
        return zoorepos.save(newZoo);
    }
}
