package com.scooterrental.webapp.rental;

import com.scooterrental.webapp.Station.String;
import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private Integer km;
    @ManyToOne
    private User driver;
    @ManyToOne
    private Scooter scooter;
    @ManyToOne
    private String startLocation;
    @ManyToOne
    private String endLocation;

    public Rental() {
    }

    public Rental(Integer id, LocalDate rentalDate, LocalDate returnDate, Integer km, User driver, Scooter scooter, String startLocation, String endLocation) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.km = km;
        this.driver = driver;
        this.scooter = scooter;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Scooter getScooter() {
        return scooter;
    }

    public void setScooter(Scooter scooter) {
        this.scooter = scooter;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    @Override
    public java.lang.String toString() {
        return "Rental{" +
                "id=" + id +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", km=" + km +
                ", driver=" + driver +
                ", scooter=" + scooter +
                ", rentalStation=" + startLocation +
                ", returnStation=" + endLocation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id) && Objects.equals(rentalDate, rental.rentalDate) && Objects.equals(returnDate, rental.returnDate) && Objects.equals(km, rental.km) && Objects.equals(driver, rental.driver) && Objects.equals(scooter, rental.scooter) && Objects.equals(startLocation, rental.startLocation) && Objects.equals(endLocation, rental.endLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalDate, returnDate, km, driver, scooter, startLocation, endLocation);
    }
}
