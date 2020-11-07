package com.gofurther.emissora.services;

import com.gofurther.emissora.entities.LoginRequest;
import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.repositories.PerformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PerformerService {

  @Autowired
  PerformerRepository performerRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  public Performer createPerformer(Performer performer) {
    String pass = passwordEncoder.encode(performer.getPassword());
    performer.setPassword(pass);
    return performerRepository.save(performer);
  }

  public Performer getByEmail(LoginRequest loginRequest) {
    return performerRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Performer does not exist"));
  }

  public List<Performer> findAllBySalaryAndGenreAndDate(double budget, String genre, LocalDateTime date, int quantity) {
    return performerRepository.findAllBySalaryAndGenreAndDate(budget / quantity, genre, date);
  }

  public List<Performer> findAllByStatusAndStarsAndSalary(boolean status, double star, double salary) {
    if (star == 0 && salary == 0) {
      return performerRepository.findAllByStatus(status);
    } else if (star == 0 && salary != 0) {
      return performerRepository.findAllByStatusAndSalary(status, salary);
    } else if (star != 0 && salary == 0) {
      return performerRepository.findAllByStatusAndStars(status, star);
    }
    return performerRepository.findAllByStatusAndStarsAndSalary(status, star, salary);
  }

  public void deletePerformer(int id) {
    performerRepository.deleteById(id);
  }
}
