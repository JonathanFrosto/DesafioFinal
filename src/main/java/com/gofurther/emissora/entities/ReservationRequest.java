package com.gofurther.emissora.entities;

import java.time.LocalDateTime;

public class ReservationRequest {

  private LocalDateTime startDate;
  private LocalDateTime finishDate;
  private String emailProducer;
  private String emailPerformer;

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

  public String getEmailProducer() {
    return emailProducer;
  }

  public void setEmailProducer(String emailProducer) {
    this.emailProducer = emailProducer;
  }

  public String getEmailPerformer() {
    return emailPerformer;
  }

  public void setEmailPerformer(String emailPerformer) {
    this.emailPerformer = emailPerformer;
  }
}
