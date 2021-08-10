package com.scooterrental.webapp.scooter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long> {

    Optional<Scooter> findScooterByMarkOfScooter(String markOfScooter);

    //NEW OPTIONAL THAT SHOWS SCOOTERS WITH BATTERY MORE THAN GOOD

    void deleteScooterByMarkOfScooter(String markOfScooter);
}
