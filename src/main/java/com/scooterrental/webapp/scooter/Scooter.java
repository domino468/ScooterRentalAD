package com.scooterrental.webapp.scooter;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Scooter {
    @Id
    private java.lang.String registrationNr;
    private Integer constructionYear;
    private Integer mileage;
    private java.lang.String model;
    private java.lang.String location;
    private String price;

    public void setRegistrationNr(java.lang.String registrationNr) {
        this.registrationNr = registrationNr.strip();
    }

    public void setModel(java.lang.String model) {
        this.model = model.strip();
    }

    public Scooter() {
    }

    public Scooter(java.lang.String registrationNr, Integer constructionYear, Integer mileage, java.lang.String model, java.lang.String location, String price) {
        this.registrationNr = registrationNr;
        this.constructionYear = constructionYear;
        this.mileage = mileage;
        this.model = model;
        this.location = location;
        this.price = price;
    }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public java.lang.String getRegistrationNr() {
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

    public java.lang.String getModel() { return model; }

    public java.lang.String getLocation() {
        return location;
    }

    public void setLocation(java.lang.String location) {
        this.location = location;
    }

    void update(Scooter scooter) {
        this.registrationNr = scooter.getRegistrationNr();
        this.constructionYear = scooter.getConstructionYear();
        this.mileage = scooter.getMileage();
        this.model = scooter.getModel();
        this.location = scooter.getLocation();
        this.price = scooter.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scooter scooter = (Scooter) o;
        return Objects.equals(registrationNr, scooter.registrationNr) && Objects.equals(constructionYear, scooter.constructionYear) && Objects.equals(mileage, scooter.mileage) && Objects.equals(model, scooter.model) && Objects.equals(location, scooter.location) && Objects.equals(price,scooter.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNr, constructionYear, mileage, model, location, price);
    }

    @Override
    public java.lang.String toString() {
        return "(" + registrationNr + ") " + model;
    }
}

