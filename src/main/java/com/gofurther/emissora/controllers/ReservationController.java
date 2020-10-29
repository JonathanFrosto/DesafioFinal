package com.gofurther.emissora.controllers;

import com.gofurther.emissora.entities.Booking;
import com.gofurther.emissora.entities.Reservation;
import com.gofurther.emissora.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping("/register")
    public ResponseEntity<Reservation> createReservation(@RequestBody Booking booking){
        return ResponseEntity.ok(reservationService.createReservation(booking));
    }

}
