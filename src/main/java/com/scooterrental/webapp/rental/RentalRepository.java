package com.scooterrental.webapp.rental;

import com.scooterrental.webapp.scooter.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
    @Query("from Rental r where r.km > 0")
    List<Rental> findRunningRentals();
    List<Rental> findByScooter(Scooter scooter);
}
