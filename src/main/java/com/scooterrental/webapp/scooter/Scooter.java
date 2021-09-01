package com.scooterrental.webapp.scooter;

import com.scooterrental.webapp.Station.Station;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Scooter {
    @Id
    private String registrationNr;
    private Integer constructionYear;
    private Integer mileage;
    private String model;
    @ManyToOne
    private Station station;

    public void setRegistrationNr(String registrationNr) {
        this.registrationNr = registrationNr.strip();
    }

    public void setModel(String model) {
        this.model = model.strip();
    }

    public Scooter() {
    }

    public Scooter(String registrationNr, Integer constructionYear, Integer mileage, String model, Station station) {
        this.registrationNr = registrationNr;
        this.constructionYear = constructionYear;
        this.mileage = mileage;
        this.model = model;
        this.station = station;
    }

    public String getRegistrationNr() {
        return registrationNr;
    }

    public Integer getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getModel() {
        return model;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scooter scooter = (Scooter) o;
        return Objects.equals(registrationNr, scooter.registrationNr) && Objects.equals(constructionYear, scooter.constructionYear) && Objects.equals(mileage, scooter.mileage) && Objects.equals(model, scooter.model) && Objects.equals(station, scooter.station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNr, constructionYear, mileage, model, station);
    }

    @Override
    public String toString() {
        return "(" + registrationNr + ") " + model;
    }
}

