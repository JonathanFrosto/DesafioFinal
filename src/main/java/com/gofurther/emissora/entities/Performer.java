package com.gofurther.emissora.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Performer extends User{
    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private Gender gender;
    private double salary;

    @ElementCollection
    private List<String> genre;


    public Gender getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}
