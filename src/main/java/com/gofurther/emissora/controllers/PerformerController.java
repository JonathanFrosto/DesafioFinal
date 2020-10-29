package com.gofurther.emissora.controllers;

import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.services.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/performer")
public class PerformerController {
    @Autowired
    PerformerService performerService;

    @PostMapping ("/register")
    public ResponseEntity<Performer> createPerformer(@RequestBody Performer performer){
        return ResponseEntity.ok(performerService.createPerformer(performer));
    }

}
