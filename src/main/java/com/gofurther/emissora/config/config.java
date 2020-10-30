package com.gofurther.emissora.config;

import com.gofurther.emissora.entities.Gender;
import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.entities.Producer;
import com.gofurther.emissora.entities.Reservation;
import com.gofurther.emissora.repositories.PerformerRepository;
import com.gofurther.emissora.repositories.ProducerRepository;
import com.gofurther.emissora.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

//@Configuration
//public class config implements CommandLineRunner {
//
//    @Autowired
//    PerformerRepository performerRepository;
//
//    @Autowired
//    ProducerRepository producerRepository;
//
//    @Autowired
//    ReservationRepository reservationRepository;
//
//
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Performer performer1 = new Performer("Jubileu","jujubeleza@gmail.com",
//                "789456123", Gender.MALE,1000.3);
//        Performer performer2 = new Performer("Creuza","creuza@gmail.com",
//                "123456789", Gender.FEMALE,1300.3);
//
//        Producer producer1 = new Producer("Marcelo","matosprogramador@gmail.com",
//                "159753");
//
//        Producer producer2 = new Producer("Rafael","rafaZaga@gmail.com",
//                "654456");
//
//
//        LocalDateTime date1 = LocalDateTime.ofInstant(Instant.parse("2020-10-28T15:01:30.408+00:00"), ZoneId.systemDefault());
//        System.out.println(date1);
//        //        LocalDateTime date2 = LocalDateTime.ofInstant(Instant.parse("2020-15-28T15:01:30.408+00:00"), ZoneId.systemDefault());
//
//        Reservation reservation1 = new Reservation(null,null,
//                producer1,performer2);
//
//        Reservation reservation2 = new Reservation(null,null,
//                producer2,performer2);
//
//        Reservation reservation3 = new Reservation(null,null,
//                producer1,performer1);
//
//        Reservation reservation4 = new Reservation(null,null,
//                producer1,performer1);
//
//
//
//        performerRepository.save(performer2);
//        performerRepository.save(performer1);
//
//        producerRepository.save(producer1);
//        producerRepository.save(producer2);
//
//        reservationRepository.save(reservation1);
//        reservationRepository.save(reservation2);
//        reservationRepository.save(reservation3);
//        reservationRepository.save(reservation4);
//    }
//}
