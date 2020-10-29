package com.gofurther.emissora.controllers;

import com.gofurther.emissora.entities.Producer;
import com.gofurther.emissora.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    ProducerService producerService;

    @PostMapping ("/register")
    public ResponseEntity<Producer> createProducer(@RequestBody Producer producer){
        return ResponseEntity.ok(producerService.createProducer(producer));
    }
}
