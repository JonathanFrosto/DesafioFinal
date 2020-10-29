package com.gofurther.emissora.services;

import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.entities.Producer;
import com.gofurther.emissora.entities.Booking;
import com.gofurther.emissora.entities.Reservation;
import com.gofurther.emissora.repositories.PerformerRepository;
import com.gofurther.emissora.repositories.ProducerRepository;
import com.gofurther.emissora.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Reservation createReservation(Booking booking){
        Producer producer = producerRepository.findByEmail(booking.getEmailProducer())
                .orElseThrow(() -> new IllegalArgumentException("This email has been used"));

        Performer performer = performerRepository.findByEmail(booking.getEmailPerformer());

        Reservation reservation = new Reservation(booking.getStartDate(), booking.getFinishDate()
                ,performer, producer);

        performer.addToReservations(reservation);
        producer.addToReservations(reservation);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Reservation reservation){
        reservationRepository.delete(reservation);
    }
}
