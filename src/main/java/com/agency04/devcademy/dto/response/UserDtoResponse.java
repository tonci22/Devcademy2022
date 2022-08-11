package com.agency04.devcademy.dto.response;

import com.agency04.devcademy.domain.Reservation;
import lombok.*;

import java.util.List;

@Data
public class UserDtoResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Reservation> reservations;

}
