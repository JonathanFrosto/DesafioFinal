package com.gofurther.emissora.config;

import com.gofurther.emissora.entities.Gender;
import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.entities.Producer;
import com.gofurther.emissora.repositories.PerformerRepository;
import com.gofurther.emissora.repositories.ProducerRepository;
import com.gofurther.emissora.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class config implements CommandLineRunner {

    @Autowired
    PerformerRepository performerRepository;

    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    ReservationRepository reservationRepository;


    @Override
    public void run(String... args) throws Exception {
        Performer performer1 = new Performer("Beltrano", "beltrano1@gmail.com", "123",
                Gender.MALE, 1000., Arrays.asList("Comedy", "Action"));
        Performer performer2 = new Performer("Beltrano", "beltrano2@gmail.com", "123",
                Gender.MALE, 1000., Arrays.asList("Comedy", "Action"));
        Performer performer3 = new Performer("Beltrano", "beltrano3@gmail.com", "123",
                Gender.MALE, 1000., Arrays.asList("Comedy", "Action"));
        Performer performer4 = new Performer("Beltrano", "beltrano4@gmail.com", "123",
                Gender.MALE, 1000., Arrays.asList("Comedy", "Action"));
        Performer performer5 = new Performer("Beltrano", "beltrano5@gmail.com", "123",
                Gender.MALE, 1000., Arrays.asList("Comedy", "Action"));
        Performer performer6 = new Performer("Beltrano", "beltrano6@gmail.com", "123",
                Gender.MALE, 1000., Arrays.asList("Comedy", "Action"));

        performerRepository.saveAll(Arrays.asList(performer1, performer2, performer3,
                performer4, performer5, performer6));

        Producer producer1 = new Producer("Ciclano", "cicrano1@gmail.com", "123");
        Producer producer2 = new Producer("Ciclano", "cicrano2@gmail.com", "123");
        Producer producer3 = new Producer("Ciclano", "cicrano3@gmail.com", "123");

        producerRepository.saveAll(Arrays.asList(producer1, producer2, producer3));
    }
}
