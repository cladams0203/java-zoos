package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.models.Telephones;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneRepository extends CrudRepository<Telephones, Long> {
}
