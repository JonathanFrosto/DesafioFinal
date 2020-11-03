package com.gofurther.emissora.services;

import com.gofurther.emissora.entities.Performer;
import com.gofurther.emissora.entities.Producer;
import com.gofurther.emissora.repositories.PerformerRepository;
import com.gofurther.emissora.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private PerformerRepository performerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (producerRepository.findByEmail(username).isPresent()) {
            Producer producer = producerRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

            return User
                    .builder()
                    .username(producer.getEmail())
                    .password(producer.getPassword())
                    .roles("USER", "ADMIN")
                    .build();
        }else{
            Performer performer = performerRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

            return User
                    .builder()
                    .username(performer.getEmail())
                    .password(performer.getPassword())
                    .roles("USER")
                    .build();
        }
    }
}
