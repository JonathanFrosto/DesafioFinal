package com.gofurther.emissora.repository;

import com.gofurther.emissora.entities.Producer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends CrudRepository<Producer,Integer> {
}
