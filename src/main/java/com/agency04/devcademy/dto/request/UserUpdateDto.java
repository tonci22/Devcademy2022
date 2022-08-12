package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.domain.Reservation;
import lombok.*;

import java.util.List;

@Value
public class UserUpdateDto {

    String firstName;
    String lastName;
    String email;

}
