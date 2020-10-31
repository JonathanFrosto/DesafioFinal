package com.gofurther.emissora.services;

import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.repositories.PerformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PerformerService {
    @Autowired
    PerformerRepository performerRepository;

    public Performer createPerformer(Performer performer){
        return performerRepository.save(performer);
    }

    public List<Performer> findAllByStarsAndSalary(boolean status, double star, double salary) {
        if (star == 0 && salary == 0) {
            return performerRepository.findAllByStatus(status);
        }else if (star == 0 && salary != 0) {
            return performerRepository.findAllByStatusAndSalary(status,salary);
        }else if (star != 0 && salary == 0) {
            return performerRepository.findAllByStatusAndStars(status,star);
        }
        return performerRepository.findAllByStatusAndStarsAndSalary(status,star,salary);
    }
}
