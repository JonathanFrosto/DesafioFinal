package com.gofurther.emissora.services;

import com.gofurther.emissora.entities.*;
import com.gofurther.emissora.repositories.PerformerRepository;
import com.gofurther.emissora.repositories.ProducerRepository;
import com.gofurther.emissora.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public List<Reservation> getAllProducerReservations(Integer producerId) {
        return reservationRepository.findAllByProducerId(producerId);
    }

    public List<Reservation> getAllPerformerReservations(Integer performerId) {
        return reservationRepository.findAllByPerformerId(performerId);
    }


    public Reservation createReservation(ReservationRequest reservationRequest) {
        Producer producer = producerRepository.findByEmail(reservationRequest.getEmailProducer())
                .orElseThrow(() -> new UsernameNotFoundException("Producer email does not exists"));

        Performer performer = performerRepository.findByEmail(reservationRequest.getEmailPerformer())
                .orElseThrow(() -> new UsernameNotFoundException("Performer email does not exists!"));

        List<Reservation> reservations = getAllPerformerReservations(performer.getId());

        LocalDateTime reqStart;
        LocalDateTime reqFinish;

        for (Reservation reservation : reservations) {
            reqStart = reservationRequest.getStartDate();
            reqFinish = reservationRequest.getFinishDate();

            if (reqStart.isAfter(reservation.getStartDate()) &&
                    reqFinish.isBefore(reservation.getFinishDate())) {
                throw new IllegalArgumentException("Date conflict");

            } else if ((reqStart.isAfter(reservation.getStartDate()) && reqStart
                    .isBefore(reservation.getFinishDate())) &&
                    reqFinish.isAfter(reservation.getFinishDate())) {
                throw new IllegalArgumentException("Date conflict");

            } else if (reqStart.isBefore(reservation.getStartDate()) &&
                    reqFinish.isAfter(reservation.getFinishDate())) {
                throw new IllegalArgumentException("Date conflict");

            } else if (reqStart.isBefore(reservation.getStartDate()) &&
                    (reqFinish.isAfter(reservation.getStartDate()) && reqFinish
                            .isBefore(reservation.getFinishDate()))) {
                throw new IllegalArgumentException("Date conflict");

            } else if (reqStart.isEqual(reservation.getStartDate()) ||
                    reqStart.isEqual(reservation.getFinishDate()) ||
                    reqFinish.isEqual(reservation.getStartDate()) ||
                    reqFinish.isEqual(reservation.getFinishDate())) {
                throw new IllegalArgumentException("Date conflict");
            }
        }

        Duration d = Duration
                .between(reservationRequest.getStartDate(), reservationRequest.getFinishDate());
        Double salary = (d.toDays() + 1) * performer.getSalary();

        Reservation reservation = new Reservation(reservationRequest.getStartDate(),
                reservationRequest.getFinishDate()
                , producer, performer, salary);

        return reservationRepository.save(reservation);
    }

    public Dashboard getDashboard(Integer id) {
        List<Reservation> reservations = getAllProducerReservations(id);
        List<Count<String>> performers = new ArrayList<>();
        List<Count<LocalDateTime>> dates = new ArrayList<>();

        Count<String> validationEmail = new Count<>();
        for (Reservation reservation : reservations) {
            String email = reservation.getPerformer().getEmail();
            validationEmail.setThing(email);
            int index = performers.indexOf(validationEmail);

            if (!(index >= 0)) {
                performers.add(new Count<>(email, 1));
            } else {
                performers.get(index).add();
            }
        }

        Count<LocalDateTime> validationDate = new Count<>();
        for (Reservation reservation : reservations) {
            LocalDateTime date = reservation.getStartDate();
            validationDate.setThing(date);
            int index = performers.indexOf(validationDate);

            if (!(index >= 0)) {
                dates.add(new Count<>(date, 1));
            } else {
                dates.get(index).add();
            }
        }

        performers.sort((c1,c2) -> -c1.getFrequency().compareTo(c2.getFrequency()));
        dates.sort((c1,c2) -> -c1.getFrequency().compareTo(c2.getFrequency()));

        List<String> mainPerformers = new ArrayList<>();
        List<LocalDateTime> mainDates = new ArrayList<>();
        for (int i=0; i< performers.size(); i++){
            mainPerformers.add(performers.get(i).getThing());
            if (i == 3) break;
        }
        for (int i=0; i< dates.size(); i++){
            mainDates.add(dates.get(i).getThing());
            if (i == 3) break;
        }

        return new Dashboard(reservations.size(),mainPerformers,mainDates);
    }

    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }
}
