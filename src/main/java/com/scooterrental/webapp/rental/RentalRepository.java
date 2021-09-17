package com.scooterrental.webapp.rental;

import com.scooterrental.webapp.scooter.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {

    List<Rental> findByScooter(Scooter scooter);
}
