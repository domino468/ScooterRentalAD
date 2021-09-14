package com.scooterrental.webapp.rental;

import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.scooter.ScooterService;
import com.scooterrental.webapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RentalService {
    @Autowired
    private FinishRentalRepository finishRentalRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private ScooterService scooterService;
    @Autowired
    private UserService userService;

    public void create(String registrationNr, String userNumber ) {
        Rental rental = new Rental();
        rental.setTransactionNumber(UUID.randomUUID());
        rental.setRentalDate(LocalDate.now());
        rental.setScooter(scooterService.findByRegistrationNr(registrationNr));
        rental.setDriver(userService.findByUserNumber(userNumber));

        rentalRepository.save(rental);
    }
//sprawdzic czy mozna zakonczyc wypozycznie , jezeli nie to rzucic wyjatkiem , a jezeli ta kto nastepny punkt
    //utworzyc nowego finish rental, nastepnie zapisac finish rental i usunac tego rentala ktory sie wlasnie zakancza
    //flow do testu - najpierw musimy rozpoczac rental
    //potem zakonczyc
    // po zakonczneiu nie mozemy miec zadnego rentala w bazie ale musimy miec jeden obiekt finish rental w bazie !

    public void finish(Rental rental, FinishRental finishRental) {
        rental.setKm(finishRental.getKm());
        rental.getScooter().setMileage(rental.getScooter().getMileage() + rental.getKm());

        rentalRepository.save(rental);
    }

    public List<Rental> findRunningRentals() {
        return rentalRepository.findAll();
    }


    public List<Rental> findByScooter(Scooter scooter) {
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
        return  finishRentalRepository.findByTransactionNumber(rental.getTransactionNumber()).isEmpty();

    }
}
