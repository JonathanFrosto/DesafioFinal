package com.gofurther.emissora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reservation extends User {
    @Id
    @GeneratedValue
    @Column(name="id_reservation")
    private int idReservation;
    @Column(name="date_start")
    private Date start;
    @Column(name="date_and")
    private Date and;
    @Column(name="fk_performer")
    private Performer performer;
    @Column(name="fk_producer")
    private Producer productor;

    public Reservation(int idReservation, Date start, Date and, Performer performer, Producer productor) {
        this.idReservation = idReservation;
        this.start = start;
        this.and = and;
        this.performer = performer;
        this.productor = productor;
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

    public Producer getProductor() {
        return productor;
    }
}
