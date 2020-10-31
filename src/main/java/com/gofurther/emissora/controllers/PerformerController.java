package com.gofurther.emissora.controllers;

import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.services.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/performer")
public class PerformerController {
    @Autowired
    PerformerService performerService;

    @PostMapping ("/register")
    public ResponseEntity<Performer> createPerformer(@RequestBody Performer performer){
        return ResponseEntity.ok(performerService.createPerformer(performer));
    }

    @GetMapping("/getAllBy")
    public ResponseEntity<List<Performer>> getAllByStatusAndStarsAndSalary(
            @RequestParam("status") boolean status,
            @RequestParam("stars") double stars,
            @RequestParam("salary") double salary){
        return ResponseEntity.ok(performerService.findAllByStarsAndSalary(status,stars,salary));
    }

}
