package com.gofurther.emissora.entities;

import java.util.Date;

public class Reserva {
    private Date inicio;
    private Date fim;
    private String emailProducer;
    private String emailPerformer;

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
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
