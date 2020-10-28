package com.gofurther.emissora.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation{
    @Id
    @GeneratedValue
    @Column(name="id_reservation")
    private int idReservation;

    @Column(name="date_start")
    private Date start;

    @Column(name="date_and")
    private Date and;
//
    @ManyToOne
    @JoinColumn(name = "performer_id")
    private Performer performer;

//    @ManyToOne
//    @JoinColumn(name="id_user")
    private Producer producer;

    public Reservation(int idReservation, Date start, Date and, Performer performer, Producer producer) {
        this.idReservation = idReservation;
        this.start = start;
        this.and = and;
        this.performer = performer;
        this.producer = producer;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public Date getStart() {
        return start;
    }

    public Date getAnd() {
        return and;
    }

    public Performer getPerformer() {
        return performer;
    }

    public Producer getProducer() {
        return producer;
    }
}
