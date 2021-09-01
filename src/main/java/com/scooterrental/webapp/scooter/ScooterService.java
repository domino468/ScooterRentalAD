package com.scooterrental.webapp.scooter;

import com.scooterrental.webapp.Station.Station;
import com.scooterrental.webapp.Station.StationService;
import com.scooterrental.webapp.util.MessagesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rental.RentalService;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class ScooterService {
    @Autowired
    private MessagesBean messages;

    @Autowired
    private ScooterRepository scooterRepository;

    @Autowired
    private StationService stationService;

    @Autowired
    private RentalService rentalService;


    public List<Scooter> findByStation(Station station) {
        return scooterRepository.findByStation(station);
    }

    public List<Scooter> findByMileageGreaterThan(Integer mileage) {
        return scooterRepository.findByMileageGreaterThan(mileage);
    }

    public Scooter create(Scooter scooter) {
        if (scooter.getStation() == null) {
            throw new IllegalArgumentException(messages.get("scooterStationNotNull"));
        }
        if (scooter.getStation().getId() == null || !stationService.existsById(scooter.getStation().getId())) {
            throw new EntityNotFoundException(messages.get("stationNotFound"));
        }
        if (scooterRepository.existsById(scooter.getRegistrationNr())) {
            throw new EntityExistsException(messages.get("scooterAlreadyExists"));
        }
        return scooterRepository.save(scooter);
    }

    public void deleteById(String registrationNr) {
        Scooter scooter = scooterRepository.findById(registrationNr)
                .orElseThrow(() -> new EntityNotFoundException(messages.get("scooterNotFound")));
        if (!canDelete(scooter)) {
            throw new IllegalArgumentException(messages.get("scooterDeleteError"));
        }
       scooterRepository.delete(scooter);
    }


    public boolean canDelete(Scooter scooter) {
        return scooter.getStation() != null && rentalService.findByCar(scooter).isEmpty();
    }
}
