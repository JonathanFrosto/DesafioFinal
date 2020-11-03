package com.gofurther.emissora.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Dashboard {
    private int numbReservations;
    private List<String> mainPerformers;
    private List<LocalDateTime> mainDates;

    public Dashboard(int numbReservations, List<String> mainPerformers, List<LocalDateTime> mainDates) {
        this.numbReservations = numbReservations;
        this.mainPerformers = mainPerformers;
        this.mainDates = mainDates;
    }

    public int getNumbReservations() {
        return numbReservations;
    }

    public List<String> getMainPerformers() {
        return mainPerformers;
    }

    public List<LocalDateTime> getMainDates() {
        return mainDates;
    }
}
