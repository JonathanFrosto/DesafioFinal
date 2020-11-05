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
        Performer performer1 = new Performer("Amanda", "amanda@gmail.com", "$2y$12$UEzDWUYS36U2rve5CJkzQO1DbQ9xZX2ueAg/Do3Lf3n.qJQwEX9ZC",
                Gender.FEMALE, 2300., 29, true, Arrays.asList("Action", "Comedy"));
        Performer performer2 = new Performer("Felipe", "felipe@gmail.com", "$2y$12$RlrKWPQYV4GEnMPJxi4BhuPtAL0/iAdceQcI6l3kaTwHBZBiQQ5aa",
                Gender.MALE, 2000., 30, true, Arrays.asList("Comedy"));
        Performer performer3 = new Performer("Pedro", "pedro@gmail.com", "$2y$12$HgqhFRzFWJyF.2g/XbHrOO8Kr//hYjZ8SM2kc2Bizd.1eneqWBj0a",
                Gender.MALE, 2200., 32, true, Arrays.asList("Drama"));
        Performer performer4 = new Performer("Beatriz", "beatriz@gmail.com", "$2y$12$ZFwLMoUFSNJGEAPrDaobweC1/9ZljBSh4Q8luFQ7Mnj4ZVL7y4EgS",
                Gender.FEMALE, 4000., 45, true, Arrays.asList("Drama", "Action", "Comedy", "Science Fiction"));
        Performer performer5 = new Performer("Leona", "leona@gmail.com", "$2y$12$o9E25fy/ni6CdCSJaYWZxuR8Up/f0lS4onkc6QSX4oTM7MfOvnxI2",
                Gender.FEMALE, 5500., 55, true, Arrays.asList("Horror", "Mystery"));
        Performer performer6 = new Performer("Bruno", "bruno@gmail.com", "$2y$12$UgL7RTLEsurM5mOQ4Hp3LecO0KQBeP1MnkglFM1VIjkIIg5tJGFOe",
                Gender.MALE, 2500., 30, true, Arrays.asList("Adventure", "Comedy", "Action"));
        Performer performer7 = new Performer("Maria", "maria@gmail.com", "$2y$12$DarFuWzxoZGg9/9jm9ZJHORH961mS2t2Mo8NLz2/6zJAZAKoPhh.q",
                Gender.MALE, 3000., 28, false, Arrays.asList("Adventure", "Comedy", "Horror"));
        Performer performer8 = new Performer("Marina", "marina@gmail.com", "$2y$12$3/2PIkxtg.53j6ygzMJKOuPHBzODQNidmL4zkjCLT4QgmCudTtypi",
                Gender.MALE, 3800., 35, true, Arrays.asList("Action", "Comedy"));
        Performer performer9 = new Performer("Angelica", "angelica@gmail.com", "$2y$12$ucyN/M2C1uhkDBpdG1BBNOK/Od9xmyR4WjizX79hWepMuxQmA819K",
                Gender.MALE, 2800., 38, true, Arrays.asList("Mystery", "Horror"));
        Performer performer10 = new Performer("Tiago", "tiago@gmail.com", "$2y$12$nNXbbMwa7CabHoZzdm/LDu069HR9CHdbo6O1gjSNdtyPlN6uj727q",
                Gender.MALE, 2800., 36, false, Arrays.asList("Action", "Fiction", "Drama"));

        performerRepository.saveAll(Arrays.asList(performer1, performer2, performer3,
                performer4, performer5, performer6, performer7, performer8, performer9, performer10));

        Producer producer1 = new Producer("Adriana", "adriana@gmail.com", "$2y$12$UJ4rXFGGabMIYER1q3YEMOzYXAGmXxWh/EfBuWkmdD3btp7cqo0H6");
        Producer producer2 = new Producer("Fernanda", "fernanda@gmail.com", "$2y$12$H2x40G28M9r492HGOc79tO1S.U3swo.J9r7dg.4TwqW6viQO9a7y6");
        Producer producer3 = new Producer("Feliciano", "feliciano@gmail.com", "$2y$12$cjhgbf/ZXLKCn0CwnforC.kVCg3MOO1D0OnzvIfet6HLvjRLgGwqK");

        producerRepository.saveAll(Arrays.asList(producer1, producer2, producer3));
    }
}
