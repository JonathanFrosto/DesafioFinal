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
    @Column(name="fk_actor")
    private Actor actor;
    @Column(name="fk_productor")
    private Productor productor;

    public Reservation(Date start, Date and, int idReservation, Actor actor, Productor productor) {
        this.start = start;
        this.and = and;
        this.idReservation = idReservation;
        this.actor = actor;
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

    public Actor getActor() {
        return actor;
    }

    public Productor getProductor() {
        return productor;
    }
}
