package com.scooterrental.webapp.scooter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long> {

    Optional<Scooter> findScooterByVinNumber(ScooterDTO vinNumber);

    Optional<Scooter> updateScooterByTown(String town);

    void deleteScooterByVinNumber(String VINNumber);
}
