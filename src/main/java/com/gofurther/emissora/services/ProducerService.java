package com.gofurther.emissora.services;

import com.gofurther.emissora.entities.Producer;
import com.gofurther.emissora.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {
    @Autowired
    ProducerRepository producerRepository;

    public Producer createProducer(Producer producer){
        return producerRepository.save(producer);
    }

    public void deleteProducer(Producer producer){
        producerRepository.delete(producer);
    }
}
