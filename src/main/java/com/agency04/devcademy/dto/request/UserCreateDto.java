package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.domain.Reservation;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserCreateDto {

    private String firstName;
    private String lastName;
    private String email;
    private List<Reservation> reservations = new ArrayList<>();

    public UserCreateDto() {
    }

    public UserCreateDto(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
