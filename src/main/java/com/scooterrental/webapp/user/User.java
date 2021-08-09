package com.scooterrental.webapp.user;

import com.scooterrental.webapp.scooter.Scooter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //historia wypożyczeń , wypozyczneie jednej hulajnogi w danym momencie na jednego uzytkownika ,
    // cennik 2 zl za wypozyczneie oraz 2 zl za kazdy przejechany kilometr oraz jak długo hulajnoga w wypozyczeniu przez uzytkownika ?
    // znizki  polegajace na historii uzytkownika na zasadzie (np.10 przejazd za darmo)
    private long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String mail;

    public User() {
    }

    public User(long id, String name, String lastName, String phoneNumber, String mail) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    void update(User user) {
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.phoneNumber = user.getPhoneNumber();
        this.mail = user.getMail();
    }
}
