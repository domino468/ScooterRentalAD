package com.scooterrental.webapp.rental;
import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.user.User;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private UUID transactionNumber;
    private LocalDateTime rentalDate;
    //1
    private Integer km;
    @ManyToOne
    private User driver;
    @ManyToOne
    private Scooter scooter;
    //2
    private double startLatitude;
    //3
    private double startLongitude;

    public Rental() {
    }

    public Rental(UUID transactionNumber, LocalDateTime rentalDate, Integer km, User driver, Scooter scooter, Long startLatitude, Long startLongitude) {
        this.transactionNumber = transactionNumber;
        this.rentalDate = rentalDate;
        this.km = km;
        this.driver = driver;
        this.scooter = scooter;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
    }

    public UUID getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(UUID transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }


    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id) && Objects.equals(transactionNumber, rental.transactionNumber) && Objects.equals(rentalDate, rental.rentalDate) && Objects.equals(km, rental.km) && Objects.equals(driver, rental.driver) && Objects.equals(scooter, rental.scooter) && Objects.equals(startLatitude, rental.startLatitude) && Objects.equals(startLongitude, rental.startLongitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionNumber, rentalDate, km, driver, scooter, startLatitude, startLongitude);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", transactionNumber=" + transactionNumber +
                ", rentalDate=" + rentalDate +
                ", km=" + km +
                ", driver=" + driver +
                ", scooter=" + scooter +
                ", startLatitude=" + startLatitude +
                ", startLongitude=" + startLongitude +
                '}';
    }
}
