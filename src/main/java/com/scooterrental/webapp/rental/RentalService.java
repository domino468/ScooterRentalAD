package com.scooterrental.webapp.rental;

import com.scooterrental.webapp.scooter.Scooter;
import com.scooterrental.webapp.scooter.ScooterService;
import com.scooterrental.webapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Rental create(String registrationNr, String userNumber , Integer km , double startLatitude, double startLongitude) {
        Rental rental = new Rental();
        rental.setTransactionNumber(UUID.randomUUID());
        rental.setRentalDate(LocalDateTime.now());
        rental.setScooter(scooterService.findByRegistrationNr(registrationNr));
        rental.setDriver(userService.findByUserNumber(userNumber));
        rental.setKm(km);
        rental.setStartLatitude(startLatitude);
        rental.setStartLongitude(startLongitude);
        return  rentalRepository.save(rental);
    }
//sprawdzic czy mozna zakonczyc wypozyczenie , jezeli nie to rzucic wyjatkiem , a jezeli ta kto nastepny punkt



    public static FinishRental fromRental(Rental rental){
        return new FinishRental(
                rental.getTransactionNumber(),
                rental.getRentalDate(),
                rental.getScooter(),
                rental.getDriver(),
                rental.getKm(),
                rental.getStartLatitude(),
                rental.getStartLongitude());
    }

    public void finish(Rental rental , double endLatitude, double endLongitude, LocalDateTime returnDate) {
        canFinish(rental);
        FinishRental finishRental = fromRental(rental);
        finishRental.setEndLatitude(endLatitude);
        finishRental.setEndLongitude(endLongitude);
        finishRental.setReturnDate(returnDate);
        finishRentalRepository.save(finishRental);
        rentalRepository.delete(rental);

    }

    public List<Rental> findRunningRentals() {
        return rentalRepository.findAll();
    }


    public List<Rental> findByScooter(Scooter scooter) {
        return rentalRepository.findByScooter(scooter);
    }


    public void canFinish(Rental rental ) {
        boolean empty = finishRentalRepository.findByTransactionNumber(rental.getTransactionNumber()).isEmpty();
        if (!empty){
            throw new RentalAlreadyFinished(rental.getTransactionNumber());
        }
    }

}
