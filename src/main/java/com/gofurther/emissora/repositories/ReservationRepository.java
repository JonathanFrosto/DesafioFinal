package com.gofurther.emissora.repositories;

import com.gofurther.emissora.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Integer> {
    List<Reservation> findAllByProducerId(Integer producerId);
    List<Reservation> findAllByPerformerId(Integer performerId);
}
