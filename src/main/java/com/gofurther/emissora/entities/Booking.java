package com.gofurther.emissora.entities;

import java.util.Date;

public class Booking {
    private Date startDate;
    private Date finishDate;
    private String emailProducer;
    private String emailPerformer;

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
