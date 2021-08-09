package com.scooterrental.webapp.scooter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //IDENTYFIKATOR BIZENSOWY (barcode)
    private String markOfScooter;
    //range zapisany za pomoca int
    private String range;
    //enum batterycondition
    private  String batteryCondition ;
    public Scooter() {
    }

    public Scooter(long id, String markOfScooter, String range, String batteryCondition) {
        this.id = id;
        this.markOfScooter = markOfScooter;
        this.range = range;
        this.batteryCondition = batteryCondition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarkOfScooter() {
        return markOfScooter;
    }

    public void setMarkOfScooter(String markOfScooter) {
        this.markOfScooter = markOfScooter;
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

    void update(Scooter scooter) {
        this.markOfScooter = scooter.getMarkOfScooter();
        this.range = scooter.getRange();
        this.batteryCondition = scooter.getBatteryCondition();
    }
}
