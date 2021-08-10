package com.scooterrental.webapp.scooter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long> {

    Optional<Scooter> findScooterByMarkOfScooter(ScooterDTO markOfScooter);

    //NEW OPTIONAL THAT SHOWS SCOOTERS WITH BATTERY MORE THAN GOOD //done - now need to  make use in scooterService

    Optional<Scooter> findScooterByBatteryCondition(String batteryCondition);

    void deleteScooterByMarkOfScooter(String markOfScooter);
}
