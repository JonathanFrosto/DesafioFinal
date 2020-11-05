package com.gofurther.emissora.controllers;

import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.services.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/performer")
public class PerformerController {

  @Autowired
  PerformerService performerService;

  @PostMapping("/register")
  public ResponseEntity<Performer> createPerformer(@RequestBody Performer performer) {
    return ResponseEntity.ok(performerService.createPerformer(performer));
  }

  @GetMapping("/getAllBy")
  public ResponseEntity<List<Performer>> getAllByStatusAndStarsAndSalary(
          @RequestParam("status") boolean status,
          @RequestParam("stars") double stars,
          @RequestParam("salary") double salary) {
    return ResponseEntity.ok(performerService.findAllByStatusAndStarsAndSalary(status, stars, salary));
  }

  @GetMapping("/searchPerformerBy")
  public ResponseEntity<List<Performer>> getAllBySalaryAndGenreAndDate(
          @RequestParam("budget") double budget,
          @RequestParam("genre") String genre,
          @RequestParam("quantity") int quantity,
          @RequestParam("date")
          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
    return ResponseEntity
            .ok(performerService.findAllBySalaryAndGenreAndDate(budget, genre, date, quantity));
  }
}
