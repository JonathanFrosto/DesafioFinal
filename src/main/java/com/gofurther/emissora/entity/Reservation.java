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
    private list<Actor> actorList;
    @Column(name="fk_productor")
    private Productor productor;

    public Reservation(int idReservation, Date start, Date and, list<Actor> actorList, Productor productor) {
        this.idReservation = idReservation;
        this.start = start;
        this.and = and;
        this.actorList = actorList;
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

    public list<Actor> getActorList() {
        return actorList;
    }

    public Productor getProductor() {
        return productor;
    }
}
