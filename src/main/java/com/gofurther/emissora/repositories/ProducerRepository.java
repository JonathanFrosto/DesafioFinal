package com.gofurther.emissora.repositories;

import com.gofurther.emissora.entities.Producer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Integer> {

  Optional<Producer> findByEmail(String email);
}
