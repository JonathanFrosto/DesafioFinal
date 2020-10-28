package com.gofurther.emissora.entities;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Performer extends User{
    private String genre;
    private List<String> acting;

    @OneToMany(mappedBy = "performer")
    private List<Reservation> reservations = new ArrayList<>();

    public Performer(Integer id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getActing() {
        return acting;
    }

    public void setActing(List<String> acting) {
        this.acting = acting;
    }
}
