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
    private String location;

    public void setRegistrationNr(String registrationNr) {
        this.registrationNr = registrationNr.strip();
    }

    public void setModel(String model) {
        this.model = model.strip();
    }

    public Scooter() {
    }

    public Scooter(String registrationNr, Integer constructionYear, Integer mileage, String model, Station station,String location)  {
        this.registrationNr = registrationNr;
        this.constructionYear = constructionYear;
        this.mileage = mileage;
        this.model = model;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    void update(Scooter scooter){
        this.registrationNr = scooter.getRegistrationNr();
        this.constructionYear = scooter.getConstructionYear();
        this.mileage = scooter.getMileage();
        this.model = scooter.getModel();
        this.location = scooter.getLocation();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scooter scooter = (Scooter) o;
        return Objects.equals(registrationNr, scooter.registrationNr) && Objects.equals(constructionYear, scooter.constructionYear) && Objects.equals(mileage, scooter.mileage) && Objects.equals(model, scooter.model) && Objects.equals(location,scooter.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNr, constructionYear, mileage, model,location);
    }

    @Override
    public String toString() {
        return "(" + registrationNr + ") " + model;
    }
}

