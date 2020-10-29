package com.gofurther.emissora.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="finish_date")
    private Date finishDate;

    @ManyToOne
    @JoinColumn(name="producer_id",nullable = false)
    private Producer producer;
//
    @ManyToOne()
    @JoinColumn(name = "performer_id",nullable = false)
    private Performer performer;

    public Reservation() {}

    public Reservation(Date startDate, Date finishDate, Performer performer, Producer producer) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.performer = performer;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }
}
