package com.scooterrental.webapp.Station;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class String {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private java.lang.String city;

    public String() {
    }

    public String(Integer id, java.lang.String city) {
        this.id = id;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getCity() {
        return city;
    }

    public void setCity(java.lang.String city) {
        this.city = city;
    }

    @Override
    public java.lang.String toString() {
        return "Station{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        String station = (String) o;
        return Objects.equals(id, station.id) && Objects.equals(city, station.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city);
    }
}
