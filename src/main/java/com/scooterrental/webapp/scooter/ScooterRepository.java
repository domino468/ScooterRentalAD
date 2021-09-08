package com.scooterrental.webapp.scooter;

import com.scooterrental.webapp.Station.Station;
import com.scooterrental.webapp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, String> {
//    List<Scooter> findByStation(Station station);
    List<Scooter> findByRegistrationNr(String registrationNr);
    List<Scooter> findByMileageGreaterThan(Integer mileage);
    List<Scooter> deleteByRegistrationNr(String registrationNr);
}
