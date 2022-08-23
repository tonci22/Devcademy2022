package com.agency04.devcademy.dto.request;

import lombok.Data;

@Data
public class UserUpdateDto {

    String firstName;
    String lastName;
    String email;
    String password;
    boolean enabled;
    boolean tokenExpired;
}
