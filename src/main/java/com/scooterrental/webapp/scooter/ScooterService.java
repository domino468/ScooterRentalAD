package com.scooterrental.webapp.scooter;

import com.scooterrental.webapp.util.MessagesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.Location;
import java.util.List;
import java.util.Optional;

@Service
public class ScooterService {
    @Autowired
    private MessagesBean messages;

    @Autowired
    private ScooterRepository scooterRepository;



    public Scooter findByRegistrationNr(String registrationNr) {
        Optional<Scooter> scooter = scooterRepository.findByRegistrationNr(registrationNr);

        return  scooter.orElseThrow(() ->  new RuntimeException("Could not Find User by user number!"));
    }

    public List<Scooter> findByMileageGreaterThan(Integer mileage) {
        return scooterRepository.findByMileageGreaterThan(mileage);
    }

    List<Scooter> findAllScooters() {
        return scooterRepository.findAll();

    }

    public Scooter createScooter(Scooter scooter) {
        return scooterRepository.save(scooter);
    }

    Scooter update(String registrationNr, Scooter updatedScooter) {
        Optional<Scooter> optionalScooter = scooterRepository
                .findByRegistrationNr((registrationNr));
        Scooter existingScooter = optionalScooter.orElseThrow(ScooterNotFoundException::new);
        existingScooter.update((updatedScooter));
        scooterRepository.save(existingScooter);
        return (existingScooter);
    }

    void deleteByRegistrationNr(String registrationNr) {
        scooterRepository.deleteByRegistrationNr(registrationNr);
    }

    public List<Scooter> findByLocation(String location) {
        return scooterRepository.findByLocation(location);
    }
public List<Scooter> findByPrice(String price){
        return  scooterRepository.findByPrice("");
}

}
