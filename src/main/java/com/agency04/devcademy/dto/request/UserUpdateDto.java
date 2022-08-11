package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.domain.Reservation;
import lombok.*;

import java.util.List;

@Data
public class UserUpdateDto {

    private String firstName;
    private String lastName;
    private String email;
    private List<Reservation> reservations;

}
