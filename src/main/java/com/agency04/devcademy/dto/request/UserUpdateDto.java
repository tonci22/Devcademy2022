package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.domain.Role;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserUpdateDto {

    String firstName;
    String lastName;
    String email;
}
