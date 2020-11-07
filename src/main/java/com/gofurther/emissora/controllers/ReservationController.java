package com.gofurther.emissora.controllers;

import com.gofurther.emissora.entities.*;
import com.gofurther.emissora.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

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

    @GetMapping("/dashboard/{id}")
    public ResponseEntity<Dashboard> getDashboard(@PathVariable("id") int id){
        return ResponseEntity.ok(reservationService.getDashboard(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation(@PathVariable("id") int id) {
      reservationService.deleteReservation(id);
      return ResponseEntity.ok("Reservation deleted with success");
    }
}
