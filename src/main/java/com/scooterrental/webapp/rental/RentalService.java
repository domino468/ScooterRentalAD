package com.scooterrental.webapp.rental;

import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.scooter.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private ScooterService scooterService;


    public void create(Rental rental) {
        rental.setId(null);
        rental.setKm(null);
        rental.setReturnDate(null);

        rentalRepository.save(rental);
    }

    public void finish(Rental rental, FinishRental finishRental) {
        rental.setKm(finishRental.getKm());
        rental.getScooter().setMileage(rental.getScooter().getMileage() + rental.getKm());

        rentalRepository.save(rental);
    }

    public List<Rental> findRunningRentals() {
        return rentalRepository.findRunningRentals();
    }


    public List<Rental> findByCar(Scooter scooter) {
        return rentalRepository.findByScooter(scooter);
    }


    public Optional<Rental> existsAndCanFinish(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        Optional<Rental> opt = rentalRepository.findById(id);
        Rental rental;
        if (opt.isPresent() && canFinish((rental = opt.get()))) {
            return Optional.of(rental);
        } else {
            return Optional.empty();
        }
    }


    public boolean canFinish(Rental rental) {
        return rental.getReturnDate() == null && rental.getKm() == null;
    }


    public boolean cleanDates(Rental rental, FinishRental finishRental) {
        if (rental.getRentalDate().isAfter(finishRental.getReturnDate())) {
            return false;
        } else {
            rental.setReturnDate(finishRental.getReturnDate());
            return true;
        }
    }
}
