package com.gofurther.emissora.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Performer extends User{
    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private Gender gender;
    private double salary;
    private double stars;
    private boolean status;

    @ElementCollection
    private List<String> genre;

    public Performer() {
    }

    public Performer(String name, String email, String password, Gender gender, double salary, double stars, boolean status, List<String> genre) {
        super(name, email, password);
        this.gender = gender;
        this.salary = salary;
        this.stars = stars;
        this.status = status;
        this.genre = genre;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
