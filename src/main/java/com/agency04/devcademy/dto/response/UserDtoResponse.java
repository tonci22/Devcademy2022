package com.agency04.devcademy.dto.response;

import com.agency04.devcademy.domain.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDtoResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean enabled;
    private boolean tokenExpired;
    private List<RoleDtoResponse> roles;
    private List<ReservationDtoResponse> reservations;
}
