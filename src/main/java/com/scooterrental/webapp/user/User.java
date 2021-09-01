package com.scooterrental.webapp.user;

import com.scooterrental.webapp.scooter.Scooter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    @Id
    private Integer userNumber;
    private String lastName;
    private String firstName;

    public void setLastName(String lastName) {
        this.lastName = lastName.strip();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.strip();
    }

    public User() {
    }

    public User(Integer userNumber, String lastName, String firstName) {
        this.userNumber = userNumber;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userNumber, user.userNumber) && Objects.equals(lastName, user.lastName) && Objects.equals(firstName, user.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNumber, lastName, firstName);
    }

    @Override
    public String toString() {
        return "(" + userNumber + ") " + lastName.toUpperCase() + ' ' + firstName;
    }
}

