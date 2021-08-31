package rental;

import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.user.User;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Rental implements Serializable {
    private  Integer id;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private Integer km;
    private User driver;
    private Scooter scooter;
    private Station rentalStation;
    private Station returnStation;

    public Rental() {
    }

    public Rental(Integer id, LocalDate rentalDate, LocalDate returnDate, Integer km, User driver, Scooter scooter, Station rentalStation, Station returnStation) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.km = km;
        this.driver = driver;
        this.scooter = scooter;
        this.rentalStation = rentalStation;
        this.returnStation = returnStation;
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

    public Station getRentalStation() {
        return rentalStation;
    }

    public void setRentalStation(Station rentalStation) {
        this.rentalStation = rentalStation;
    }

    public Station getReturnStation() {
        return returnStation;
    }

    public void setReturnStation(Station returnStation) {
        this.returnStation = returnStation;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", km=" + km +
                ", driver=" + driver +
                ", scooter=" + scooter +
                ", rentalStation=" + rentalStation +
                ", returnStation=" + returnStation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id) && Objects.equals(rentalDate, rental.rentalDate) && Objects.equals(returnDate, rental.returnDate) && Objects.equals(km, rental.km) && Objects.equals(driver, rental.driver) && Objects.equals(scooter, rental.scooter) && Objects.equals(rentalStation, rental.rentalStation) && Objects.equals(returnStation, rental.returnStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalDate, returnDate, km, driver, scooter, rentalStation, returnStation);
    }
}
