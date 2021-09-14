package com.scooterrental.webapp.rental;

import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.user.User;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
@Entity
public class FinishRental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private UUID transactionNumber;
    private LocalDate rentalDate;
    @ManyToOne
    private User user;
    @ManyToOne
    private Scooter scooter;
    private Long startLatitude;
    private Long endLatitude;
    private Long startLongitude;
    private Long endLongitude;
    private LocalDate returnDate;
    private Integer km;

    public FinishRental() {
    }

    public FinishRental(UUID transactionNumber, LocalDate rentalDate, User user, Scooter scooter, Long startLatitude, Long endLatitude, Long startLongitude, Long endLongitude, LocalDate returnDate, Integer km) {
        this.transactionNumber = transactionNumber;
        this.rentalDate = rentalDate;
        this.user = user;
        this.scooter = scooter;
        this.startLatitude = startLatitude;
        this.endLatitude = endLatitude;
        this.startLongitude = startLongitude;
        this.endLongitude = endLongitude;
        this.returnDate = returnDate;
        this.km = km;
    }

    public UUID getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(UUID transactionNumber) {
        this.transactionNumber = transactionNumber;
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

    public Long getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(Long startLatitude) {
        this.startLatitude = startLatitude;
    }

    public Long getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(Long endLatitude) {
        this.endLatitude = endLatitude;
    }

    public Long getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(Long startLongitude) {
        this.startLongitude = startLongitude;
    }

    public Long getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(Long endLongitude) {
        this.endLongitude = endLongitude;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinishRental that = (FinishRental) o;
        return Objects.equals(id, that.id) && Objects.equals(transactionNumber, that.transactionNumber) && Objects.equals(rentalDate, that.rentalDate) && Objects.equals(user, that.user) && Objects.equals(scooter, that.scooter) && Objects.equals(startLatitude, that.startLatitude) && Objects.equals(endLatitude, that.endLatitude) && Objects.equals(startLongitude, that.startLongitude) && Objects.equals(endLongitude, that.endLongitude) && Objects.equals(returnDate, that.returnDate) && Objects.equals(km, that.km);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionNumber, rentalDate, user, scooter, startLatitude, endLatitude, startLongitude, endLongitude, returnDate, km);
    }

    @Override
    public String toString() {
        return "FinishRental{" +
                "id=" + id +
                ", transactionNumber=" + transactionNumber +
                ", rentalDate=" + rentalDate +
                ", user=" + user +
                ", scooter=" + scooter +
                ", startLatitude=" + startLatitude +
                ", endLatitude=" + endLatitude +
                ", startLongitude=" + startLongitude +
                ", endLongitude=" + endLongitude +
                ", returnDate=" + returnDate +
                ", km=" + km +
                '}';
    }
}
