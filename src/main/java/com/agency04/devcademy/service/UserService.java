package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.User;
import com.agency04.devcademy.dto.request.*;

import java.util.List;

public interface UserService {
    User add(UserCreateDto userCreateDto);
    List<User> addAll(List<UserCreateDto> userCreateDtos);
    List<User> getAll();
    User updateUser(Long id, UserUpdateDto userUpdateDto);
    void deleteById(Long id);

    User addReservation(Long id, Long idAccommodation, ReservationCreateDto reservationCreateDto);
    User updateReservation(Long idLocation, Long idReservation, ReservationUpdateDto reservationUpdateDto);
}
