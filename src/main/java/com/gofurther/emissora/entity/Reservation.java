package com.gofurther.emissora.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="date_start")
    private Date start;

    @Column(name="date_finish")
    private Date finish;

    @ManyToOne
    @JoinColumn(name="fk_performer")
    private Performer performer;

    @ManyToOne
    @JoinColumn(name="fk_producer")
    private Producer producer;

    public int getId() {
        return id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
