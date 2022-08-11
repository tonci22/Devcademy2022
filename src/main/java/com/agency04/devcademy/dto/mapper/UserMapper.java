package com.agency04.devcademy.dto.mapper;

import com.agency04.devcademy.domain.User;
import com.agency04.devcademy.dto.request.UserCreateDto;
import com.agency04.devcademy.dto.request.UserUpdateDto;
import com.agency04.devcademy.dto.response.UserDtoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public User mapToDto(UserCreateDto userCreateDto){
        User user = new User();
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setEmail(userCreateDto.getEmail());
        user.setReservations(userCreateDto.getReservations());

        return user;
    }

    public User mapToDto(Long id, UserUpdateDto userUpdateDto){
        User user = new User();
        user.setId(id);
        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());
        user.setEmail(userUpdateDto.getEmail());
        user.setReservations(userUpdateDto.getReservations());

        return user;
    }

    public UserDtoResponse mapToDto(User user){
        UserDtoResponse userDtoResponse = new UserDtoResponse();
        userDtoResponse.setId(user.getId());
        userDtoResponse.setFirstName(user.getFirstName());
        userDtoResponse.setLastName(user.getLastName());
        userDtoResponse.setEmail(user.getEmail());
        userDtoResponse.setReservations(user.getReservations());

        return userDtoResponse;
    }

    public List<UserDtoResponse> mapToDto(List<User> users){
        List<UserDtoResponse> userDtoResponses = new ArrayList<>();

        for (User user: users){
            userDtoResponses.add(mapToDto(user));
        }
        return userDtoResponses;
    }
}
