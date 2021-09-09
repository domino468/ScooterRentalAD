package com.scooterrental.webapp.scooter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.stream.Location;
import java.util.List;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, String> {
//    List<Scooter> findByLocation(Location location);
    List<Scooter> findByRegistrationNr(String registrationNr);
    List<Scooter> findByMileageGreaterThan(Integer mileage);
    void deleteByRegistrationNr(String registrationNr);
}
