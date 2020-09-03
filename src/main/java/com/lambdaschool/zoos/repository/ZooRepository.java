package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.models.Zoos;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoos, Long> {
}
