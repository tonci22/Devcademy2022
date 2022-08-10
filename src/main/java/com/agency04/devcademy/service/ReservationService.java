package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;

import java.util.List;

public interface ReservationService {

    Reservation add(ReservationCreateDto reservation);
    List<Reservation> addAll(List<Reservation> reservations);
    List<Reservation> getAll();
    Reservation updateReservation(Long id, ReservationUpdateDto reservation);

    void deleteById(Long id);
}
