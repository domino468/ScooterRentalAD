package com.scooterrental.webapp.rental;

import java.util.UUID;

public class RentalAlreadyFinished extends RuntimeException{
    public RentalAlreadyFinished(UUID rentalNumber) {
        super("Rental is already finished " + rentalNumber);
    }
}
