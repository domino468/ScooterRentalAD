package com.scooterrental.webapp.scooter;

public class ScooterNotFoundException extends RuntimeException {
    public ScooterNotFoundException() {
        super("scooter not found");
    }
}
