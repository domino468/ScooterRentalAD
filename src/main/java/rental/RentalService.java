package rental;

import com.scooterrental.webapp.scooter.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private ScooterService scooterService;


    public void create(Rental rental){
        rental.setId(null);
        rental.setKm(null);
        rental.setReturnDate(null);
        rental.setReturnStation(null);
        rental.getScooter().setMarkOfScooter(null);

        rentalRepository.save(rental);
    }

    public void finish(Rental rental ,  FinishRental finishRental){
        rental.setReturnStation(finishRental.getReturnStation());
        rental.setKm(finishRental.getKm());
        rental.getScooter().setStation(rental.getReturnStation());
        rental.getScooter().setBarcode(rental.getScooter().getBatteryCondition() + rental.getKm());

        rentalRepository.save(rental);
    }
    public List<Rental> findRunningRentals(){
        return  rentalRepository.findRunningRentals();
    }
    public boolean canFinish(Rental rental) {
        if (rental.getReturnDate() == null && rental.getKm() == null) {
            rental.getReturnStation();
        }
        return false;
    }
    public boolean canCreate(Rental rental) {
        return scooterService.findAllScooters().contains(rental.getScooter());
    }
}
