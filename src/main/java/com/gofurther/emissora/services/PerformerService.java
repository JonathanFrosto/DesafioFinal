package com.gofurther.emissora.services;

import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.repositories.PerformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PerformerService {
    @Autowired
    PerformerRepository performerRepository;

    public Performer createPerformer(Performer performer){
        return performerRepository.save(performer);
    }
}
