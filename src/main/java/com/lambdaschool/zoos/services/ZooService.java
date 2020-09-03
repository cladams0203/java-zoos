package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoos;

public interface ZooService {

    Zoos save(Zoos zoo);

    Zoos findByZooId(long id);
}
