package com.gofurther.emissora.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Performer extends User {

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ElementCollection
    @Column(name="acting_genre")
    private List<String> actingGenre = new ArrayList<>();

    @OneToMany(mappedBy = "performer")
    private List<Reservation> reservations = new ArrayList<>();

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<String> getActingGenre() {
        return actingGenre;
    }

    public void setActingGenre(List<String> actingGenre) {
        this.actingGenre = actingGenre;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
