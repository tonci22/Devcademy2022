package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.dto.response.RoleDtoResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserCreateDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean enabled;
    private boolean tokenExpired;
    private List<ReservationCreateDto> reservations = new ArrayList<>();
    private List<RoleDtoResponse> roles = new ArrayList<>();

    public UserCreateDto() {
    }

    public UserCreateDto(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
