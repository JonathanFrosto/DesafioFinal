package com.gofurther.emissora.controllers;

import com.gofurther.emissora.entities.LoginRequest;
import com.gofurther.emissora.entities.Producer;
import com.gofurther.emissora.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/producer")
public class ProducerController {

  @Autowired
  ProducerService producerService;

  @PostMapping("/register")
  public ResponseEntity<Producer> createProducer(@RequestBody Producer producer) {
    return ResponseEntity.ok(producerService.createProducer(producer));
  }

  @GetMapping("/getByEmail")
  public ResponseEntity<Producer> getProducerByEmail(@RequestBody LoginRequest loginRequest) {
    return ResponseEntity.ok(producerService.getByEmail(loginRequest));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteProducer(@PathVariable("id") int id) {
    producerService.deleteProducer(id);
    return ResponseEntity.ok("Producer deleted with success");
  }
}
