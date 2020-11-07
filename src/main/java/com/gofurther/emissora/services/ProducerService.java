package com.gofurther.emissora.services;

import com.gofurther.emissora.entities.LoginRequest;
import com.gofurther.emissora.entities.Producer;
import com.gofurther.emissora.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

  @Autowired
  ProducerRepository producerRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  public Producer createProducer(Producer producer) {
    String pass = passwordEncoder.encode(producer.getPassword());
    producer.setPassword(pass);
    return producerRepository.save(producer);
  }

  public Producer getByEmail(LoginRequest loginRequest) {
    return producerRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Producer does not exist"));
  }

  public void deleteProducer(int id) {
    producerRepository.deleteById(id);
  }
}
