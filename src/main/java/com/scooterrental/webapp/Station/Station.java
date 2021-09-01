package com.scooterrental.webapp.Station;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;

    public Station() {
    }

    public Station(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(id, station.id) && Objects.equals(city, station.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city);
    }
}
