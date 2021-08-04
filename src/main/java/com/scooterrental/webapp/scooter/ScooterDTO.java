package com.scooterrental.webapp.scooter;

import java.util.Objects;

public class ScooterDTO {
    private final String markOfScooter;
    private String range;
    private String batteryCondition;

    public ScooterDTO(String markOfScooter, String range, String batteryCondition) {
        this.markOfScooter = markOfScooter;
        this.range = range;
        this.batteryCondition = batteryCondition;
    }

    public String getMarkOfScooter() {
        return markOfScooter;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getBatteryCondition() {
        return batteryCondition;
    }

    public void setBatteryCondition(String batteryCondition) {
        this.batteryCondition = batteryCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScooterDTO that = (ScooterDTO) o;
        return Objects.equals(markOfScooter, that.markOfScooter) && Objects.equals(range, that.range) && Objects.equals(batteryCondition, that.batteryCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(markOfScooter, range, batteryCondition);
    }
}
