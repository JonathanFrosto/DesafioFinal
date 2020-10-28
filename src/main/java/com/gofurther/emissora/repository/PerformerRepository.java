package com.gofurther.emissora.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformerRepository extends CrudRepository<Performer,Integer> {
}
