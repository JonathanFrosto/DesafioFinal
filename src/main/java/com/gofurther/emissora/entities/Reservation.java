package com.gofurther.emissora.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_reservation")
    private int idReservation;

    @Column(name="date_start")
    private Date start;

    @Column(name="date_and")
    private Date finish;
//
    @ManyToOne
    @JoinColumn(name = "performer_id")
    private Performer performer;

    @ManyToOne
    @JoinColumn(name="id_user")
    private Producer producer;

    public Reservation(Date start, Date finish, Performer performer, Producer producer) {
        this.start = start;
        this.finish = finish;
        this.performer = performer;
        this.producer = producer;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public Date getStart() {
        return start;
    }

    public Date getFinish() {
        return finish;
    }

    public Performer getPerformer() {
        return performer;
    }

    public Producer getProducer() {
        return producer;
    }
}
