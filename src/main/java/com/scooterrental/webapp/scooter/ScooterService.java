package com.scooterrental.webapp.scooter;

import com.scooterrental.webapp.Station.Station;
import com.scooterrental.webapp.Station.StationService;
import com.scooterrental.webapp.util.MessagesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScooterService {
    @Autowired
    private MessagesBean messages;

    @Autowired
    private ScooterRepository scooterRepository;

    @Autowired
    private StationService stationService;


//    public List<Scooter> findByStation(Station station) {
//        return scooterRepository.findByStation(station);
//    }

    public List<Scooter> findByRegistrationNr(String registrationNr){return  scooterRepository.findByRegistrationNr(registrationNr);}
    public List<Scooter> findByMileageGreaterThan(Integer mileage) {
        return scooterRepository.findByMileageGreaterThan(mileage);
    }
    List<Scooter> showAllScooters(){
        return  scooterRepository.findAll()
                .stream()
                .map(this::create).collect(Collectors.toList());
    }
    public Scooter create(Scooter scooter) {

//        if (scooter.getRegistrationNr() == null) {
//            throw new IllegalArgumentException(messages.get("scooterStationNotNull"));
//        }
////        if (scooter.getStation().getId() == null || !stationService.existsById(scooter.getStation().getId())) {
////            throw new EntityNotFoundException(messages.get("stationNotFound"));
////        }
//        if (scooterRepository.existsById(scooter.getRegistrationNr())) {
//            throw new EntityExistsException(messages.get("scooterAlreadyExists"));
//        }
        return scooterRepository.save(scooter);
    }

    void deleteByRegistrationNr(String registrationNr){
        scooterRepository.deleteByRegistrationNr(registrationNr);
    }
//    public void deleteById(String registrationNr) {
//        Scooter scooter = scooterRepository.findById(registrationNr)
//                .orElseThrow(() -> new EntityNotFoundException(messages.get("scooterNotFound")));
//        if (!canDelete(scooter)) {
//            throw new IllegalArgumentException(messages.get("scooterDeleteError"));
//        }
//       scooterRepository.delete(scooter);
//    }


//    public boolean canDelete(Scooter scooter) {
//        RentalRepository rentalService;
//        return scooter.getStation() != null && rentalService.findByScooter(scooter).isEmpty();
//    }
}
