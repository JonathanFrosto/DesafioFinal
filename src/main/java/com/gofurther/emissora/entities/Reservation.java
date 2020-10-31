package com.gofurther.emissora.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private LocalDateTime startDate;

  @Column(nullable = false)
  private LocalDateTime finishDate;

  @ManyToOne
  @JoinColumn(name = "producer_id", nullable = false)
  private Producer producer;
  //
  @ManyToOne()
  @JoinColumn(name = "performer_id", nullable = false)
  private Performer performer;

  @Column(precision = 10, scale = 2)
  private double value;

  public Reservation() {
  }

  public Reservation(LocalDateTime startDate, LocalDateTime finishDate, Producer producer,
      Performer performer, double value) {
    this.startDate = startDate;
    this.finishDate = finishDate;
    this.producer = producer;
    this.performer = performer;
    this.value = value;
  }

  public int getId() {
    return id;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getFinishDate() {
    return finishDate;
  }

  public void setFinishDate(LocalDateTime finishDate) {
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

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }
}
