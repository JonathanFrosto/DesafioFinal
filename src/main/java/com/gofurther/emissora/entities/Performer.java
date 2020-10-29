package com.gofurther.emissora.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Performer extends User{
    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private Gender gender;

    @ElementCollection
    private List<String> genre;

    @OneToMany(mappedBy = "performer")
    private List<Reservation> reservations = new ArrayList<>();

    public void addToReservations(Reservation reservation){
        reservations.add(reservation);
    }

    public List<Reservation> showReservations() {
        return reservations;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}
