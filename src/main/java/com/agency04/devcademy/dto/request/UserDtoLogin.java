package com.agency04.devcademy.dto.request;

import lombok.Data;

@Data
public class UserDtoLogin {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
