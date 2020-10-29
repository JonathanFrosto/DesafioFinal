package com.gofurther.emissora.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Performer extends User{
    private String genre;
    private String acting;
    private Double salary;

    @OneToMany(mappedBy = "performer")
    private List<Reservation> reservations = new ArrayList<>();

    public void addToReservations(Reservation reservation){
        reservations.add(reservation);
    }
    public List<Reservation> showReservations() {
        return reservations;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActing() {
        return acting;
    }

    public void setActing(String acting) {
        this.acting = acting;
    }
}
