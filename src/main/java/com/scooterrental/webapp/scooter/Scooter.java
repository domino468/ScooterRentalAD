package com.scooterrental.webapp.scooter;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String registrationNr;
    private Integer constructionYear;
    private Integer mileage;
    private String model;
    private String location;
    private String price;

    public void setRegistrationNr(String registrationNr) {
        this.registrationNr = registrationNr.strip();
    }

    public void setModel(java.lang.String model) {
        this.model = model.strip();
    }

    public Scooter() {
    }

    public Scooter(java.lang.String registrationNr, Integer constructionYear, Integer mileage, String model, String location, String price) {
        this.registrationNr = registrationNr;
        this.constructionYear = constructionYear;
        this.mileage = mileage;
        this.model = model;
        this.location = location;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return Objects.equals(id, scooter.id) && Objects.equals(registrationNr, scooter.registrationNr) && Objects.equals(constructionYear, scooter.constructionYear) && Objects.equals(mileage, scooter.mileage) && Objects.equals(model, scooter.model) && Objects.equals(location, scooter.location) && Objects.equals(price, scooter.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationNr, constructionYear, mileage, model, location, price);
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "id=" + id +
                ", registrationNr='" + registrationNr + '\'' +
                ", constructionYear=" + constructionYear +
                ", mileage=" + mileage +
                ", model='" + model + '\'' +
                ", location='" + location + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

