package com.scooterrental.webapp.scooter;

import com.scooterrental.webapp.Station.StationService;
import com.scooterrental.webapp.util.MessagesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public List<Scooter> findByRegistrationNr(String registrationNr) {
        return scooterRepository.findByRegistrationNr(registrationNr);
    }

    public List<Scooter> findByMileageGreaterThan(Integer mileage) {
        return scooterRepository.findByMileageGreaterThan(mileage);
    }

    List<Scooter> showAllScooters() {
        return scooterRepository.findAll()
                .stream()
                .map(this::createScooter)
                .collect(Collectors.toList());
    }

    public Scooter createScooter(Scooter scooter) {


        return scooterRepository.save(scooter);
    }

    void deleteByRegistrationNr(String registrationNr) {
        scooterRepository.deleteByRegistrationNr(registrationNr);
    }
}
