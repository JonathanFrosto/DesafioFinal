package com.gofurther.emissora.repositories;

import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.entities.Producer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformerRepository extends CrudRepository<Performer,Integer> {
    Performer findByEmail(String email);
}
