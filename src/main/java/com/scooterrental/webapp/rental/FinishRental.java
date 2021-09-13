package com.scooterrental.webapp.rental;

import com.scooterrental.webapp.Station.String;
import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.user.User;


import java.time.LocalDate;

public class FinishRental {
    private Integer id;
    private LocalDate rentalDate;
    private User user;
    private Scooter scooter;
    private String startLocation;
    private String endLocation;
    private LocalDate returnDate;
    private Integer km;

    public FinishRental(Integer id, LocalDate rentalDate, java.lang.String driver, Scooter scooter, String rentalStation, LocalDate now, Object returnStation, int km) {
    }

    public FinishRental(Integer id, LocalDate rentalDate, User user, Scooter scooter, String startLocation, LocalDate returnDate, String endLocation, Integer km) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.user = user;
        this.scooter = scooter;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.returnDate = returnDate;
        this.km = km;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public static FinishRental fromRental(Rental rental) {
        return new FinishRental(
                rental.getId(),
                rental.getRentalDate(),
                rental.getDriver(),
                rental.getScooter(),
                rental.getStartLocation(),
                LocalDate.now(),
                null,
                0
        );
    }
}
