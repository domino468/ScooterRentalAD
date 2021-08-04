package com.scooterrental.webapp.scooter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long> {

    Optional<Scooter> findScooterByMark(ScooterDTO markOfScooter);

    Optional<Scooter> updateScooterByRange(String range);

    void deleteScooterByMark(String markOfScooter);
}
