package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.models.Animals;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animals, Long> {
}
