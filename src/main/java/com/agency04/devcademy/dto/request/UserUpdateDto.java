package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.domain.Reservation;

import java.util.List;

public class UserUpdateDto {

    private String firstName;
    private String lastName;
    private String email;
    private List<Reservation> reservations;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}