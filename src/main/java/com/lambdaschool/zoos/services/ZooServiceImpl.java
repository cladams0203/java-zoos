package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoos;
import com.lambdaschool.zoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

public class ZooServiceImpl implements ZooService {

    @Autowired
    ZooRepository zoorepos;

    @Override
    public Zoos findByZooId(long id) {
        return zoorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo " + id + " Not Found"));
    }

    @Override
    public Zoos save(Zoos zoo) {
        return null;
    }
}
