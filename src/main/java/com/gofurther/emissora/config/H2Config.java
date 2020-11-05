package com.gofurther.emissora.config;

import com.gofurther.emissora.entities.Gender;
import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.entities.Producer;
import com.gofurther.emissora.repositories.PerformerRepository;
import com.gofurther.emissora.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class H2Config implements CommandLineRunner {

    @Autowired
    PerformerRepository performerRepository;

    @Autowired
    ProducerRepository producerRepository;

    @Override
    public void run(String... args) throws Exception {
        Performer performer1 = new Performer("Amanda", "amanda1@gmail.com", "ama123",
                Gender.FEMALE, 2300., 29, true, Arrays.asList("Action", "Comedy"));
        Performer performer2 = new Performer("Felipe", "felipe@gmail.com", "fel123",
                Gender.MALE, 2000., 30, true, Arrays.asList("Comedy"));
        Performer performer3 = new Performer("Pedro", "pedro@gmail.com", "ped123",
                Gender.MALE, 2200., 32, true, Arrays.asList("Drama"));
        Performer performer4 = new Performer("Beatriz", "beatriz@gmail.com", "bea123",
                Gender.FEMALE, 4000., 45, true, Arrays.asList("Drama", "Action", "Comedy", "Science Fiction"));
        Performer performer5 = new Performer("Leona", "leona@gmail.com", "leo123",
                Gender.FEMALE, 5500., 55, true, Arrays.asList("Horror", "Mystery"));
        Performer performer6 = new Performer("Bruno", "bruno@gmail.com", "bru123",
                Gender.MALE, 2500., 30, true, Arrays.asList("Adventure", "Comedy", "Action"));
        Performer performer7 = new Performer("Maria", "maria@gmail.com", "mar123",
                Gender.MALE, 3000., 28, false, Arrays.asList("Adventure", "Comedy", "Horror"));
        Performer performer8 = new Performer("Marina", "marina@gmail.com", "mar123",
                Gender.MALE, 3800., 35, true, Arrays.asList("Action", "Comedy"));
        Performer performer9 = new Performer("Angelica", "angelica@gmail.com", "ang123",
                Gender.MALE, 2800., 38, true, Arrays.asList("Mystery", "Horror"));
        Performer performer10 = new Performer("Tiago", "tiago@gmail.com", "tia123",
                Gender.MALE, 2800., 36, false, Arrays.asList("Action", "Fiction", "Drama"));

        performerRepository.saveAll(Arrays.asList(performer1, performer2, performer3,
                performer4, performer5, performer6, performer7, performer8, performer9, performer10));

        Producer producer1 = new Producer("Adriana", "adriana@gmail.com", "adri123");
        Producer producer2 = new Producer("Fernanda", "fernanda@gmail.com", "fer123");
        Producer producer3 = new Producer("Feliciano", "feliciano@gmail.com", "fel123");

        producerRepository.saveAll(Arrays.asList(producer1, producer2, producer3));
    }
}
