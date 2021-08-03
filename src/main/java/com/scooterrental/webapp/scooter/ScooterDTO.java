package com.scooterrental.webapp.scooter;

import java.util.Objects;

public class ScooterDTO {
    private final String VINNumber;
    private String town;

    public ScooterDTO(String VINNumber, String town) {
        this.VINNumber = VINNumber;
        this.town = town;
    }

    public String getVINNumber() {
        return VINNumber;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScooterDTO that = (ScooterDTO) o;
        return Objects.equals(VINNumber, that.VINNumber) && Objects.equals(town, that.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VINNumber, town);
    }
}
