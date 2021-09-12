package com.scooterrental.webapp.user;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String userNumber;
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

    public User(long id, String userNumber, String lastName, String firstName) {
        this.id = id;
        this.userNumber = userNumber;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
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
        return id == user.id && Objects.equals(userNumber, user.userNumber) && Objects.equals(lastName, user.lastName) && Objects.equals(firstName, user.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userNumber, lastName, firstName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userNumber='" + userNumber + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}

