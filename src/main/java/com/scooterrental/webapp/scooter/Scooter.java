package com.scooterrental.webapp.scooter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vinNumber;
    private String town;

    public Scooter() {
    }

    public Scooter(long id, String VINOfScooter, String town) {
        this.id = id;
        this.vinNumber = VINOfScooter;
        this.town = town;
    }

    public long getId() {
        return id;
    }

    public String getVINOfScooter() {
        return vinNumber;
    }

    public void setVINOfScooter(String VINOfScooter) {
        this.vinNumber = VINOfScooter;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    void update(Scooter scooter) {
        this.vinNumber = scooter.getVINOfScooter();
        this.town = scooter.getTown();
    }
}
