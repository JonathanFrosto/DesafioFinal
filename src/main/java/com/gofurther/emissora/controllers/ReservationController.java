package com.gofurther.emissora.controllers;

import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.entities.ReservationRequest;
import com.gofurther.emissora.entities.Reservation;
import com.gofurther.emissora.repositories.ReservationRepository;
import com.gofurther.emissora.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    ReservationRepository reservationRepository;

    @PostMapping("/register")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequest reservationRequest){
        return ResponseEntity.ok(reservationService.createReservation(reservationRequest));
    }

    @GetMapping("/producer/{id}")
    public ResponseEntity<List<Reservation>> getAllProducerReservations (@PathVariable("id")int producerId){
        return ResponseEntity.ok(reservationService.getAllProducerReservations(producerId));
    }

    @GetMapping("/performer/{id}")
    public ResponseEntity<List<Reservation>> getAllPerformerReservations (@PathVariable("id")int performerId){
        return ResponseEntity.ok(reservationService.getAllPerformerReservations(performerId));
    }

//    @GetMapping("/getTest")
//    public ResponseEntity<List<Reservation>> getAllByGenreAndDateAndSalary(
//            @RequestParam("genre") String genre,
//            @RequestParam("budget") double budget)
//    {
//
//        return ResponseEntity.ok(reservationRepository.findAllByPerformerGenreAndPerformerSalaryLessThanEqual(genre,budget));
//    }

}
