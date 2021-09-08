package com.scooterrental.webapp.rental;

import com.scooterrental.webapp.Station.Station;
import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.user.User;


import java.time.LocalDate;

public class FinishRental {
    private Integer id;
    private LocalDate rentalDate;
    private User user;
    private Scooter scooter;
    private Station rentalStation;
    private LocalDate returnDate;
    private Station returnStation;
    private Integer km;

    public FinishRental(Integer id, LocalDate rentalDate, String driver, Scooter scooter, Station rentalStation, LocalDate now, Object returnStation, int km) {
    }

    public FinishRental(Integer id, LocalDate rentalDate, User user, Scooter scooter, Station rentalStation, LocalDate returnDate, Station returnStation, Integer km) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.user = user;
        this.scooter = scooter;
        this.rentalStation = rentalStation;
        this.returnDate = returnDate;
        this.returnStation = returnStation;
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

    public Station getRentalStation() {
        return rentalStation;
    }

    public void setRentalStation(Station rentalStation) {
        this.rentalStation = rentalStation;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Station getReturnStation() {
        return returnStation;
    }

    public void setReturnStation(Station returnStation) {
        this.returnStation = returnStation;
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
                rental.getRentalStation(),
                LocalDate.now(),
                null,
                0
        );
    }
}
