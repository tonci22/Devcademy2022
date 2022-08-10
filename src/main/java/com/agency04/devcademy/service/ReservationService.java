package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;

import java.util.List;

public interface ReservationService {
    Reservation add(ReservationCreateDto reservationCreateDto);
    List<Reservation> addAll(List<ReservationCreateDto> reservationCreateDtos);
    List<Reservation> getAll();
    Reservation updateReservation(Long id, ReservationUpdateDto reservationUpdateDto);
    Reservation getById(Long id);
    void deleteById(Long id);
}
