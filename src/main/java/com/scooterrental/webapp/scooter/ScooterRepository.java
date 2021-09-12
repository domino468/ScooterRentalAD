package com.scooterrental.webapp.scooter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.stream.Location;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long> {
//    List<Scooter> findByLocation(Location location);
    Optional<Scooter> findByRegistrationNr(String registrationNr);
    List<Scooter> findByMileageGreaterThan(Integer mileage);
    void deleteByRegistrationNr(String registrationNr);
}
