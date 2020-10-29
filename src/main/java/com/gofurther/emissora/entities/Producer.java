package com.gofurther.emissora.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Producer extends User {
    @OneToMany(mappedBy = "producer")
    private List<Reservation> reservations = new ArrayList<>();

    public void addToReservations(Reservation reservation){
        reservations.add(reservation);
    }
    public List<Reservation> showReservations() {
        return reservations;
    }

}
