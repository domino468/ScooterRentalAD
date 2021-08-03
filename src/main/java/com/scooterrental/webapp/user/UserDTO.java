package com.scooterrental.webapp.user;

import java.util.Objects;

public class UserDTO {
    private final String name;
    private final String lastName;
    private String mail;
    private String phoneNumber;

    public UserDTO(String name, String lastName, String mail, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(name, userDTO.name) && Objects.equals(lastName, userDTO.lastName) && Objects.equals(mail, userDTO.mail) && Objects.equals(phoneNumber, userDTO.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, mail, phoneNumber);
    }
}
