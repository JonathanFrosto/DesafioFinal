package com.gofurther.emissora.services;

import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.entities.Producer;
import com.gofurther.emissora.entities.ReservationRequest;
import com.gofurther.emissora.entities.Reservation;
import com.gofurther.emissora.repositories.PerformerRepository;
import com.gofurther.emissora.repositories.ProducerRepository;
import com.gofurther.emissora.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    PerformerRepository performerRepository;

    public ReservationRepository getReservationRepository() {
        return reservationRepository;
    }

    public List<Reservation> getAllProducerReservations(Integer producerId){
        return reservationRepository.findAllByProducerId(producerId);
    }

    public List<Reservation> getAllPerformerReservations(Integer performerId){
        return reservationRepository.findAllByProducerId(performerId);
    }

    public Reservation createReservation(ReservationRequest reservationRequest){

        Producer producer = producerRepository.findByEmail(reservationRequest.getEmailProducer())
                .orElseThrow(() -> new IllegalArgumentException("This email has been used"));

        Performer performer = performerRepository.findByEmail(reservationRequest.getEmailPerformer());

        Duration d = Duration.between(reservationRequest.getStartDate(),reservationRequest.getFinishDate());
        Double salary = (d.toDays()+1)* performer.getSalary();

        Reservation reservation = new Reservation(reservationRequest.getStartDate(), reservationRequest.getFinishDate()
                , producer,performer,salary);


        return reservationRepository.save(reservation);

    }

    public void deleteReservation(Reservation reservation){
        reservationRepository.delete(reservation);
    }
}
