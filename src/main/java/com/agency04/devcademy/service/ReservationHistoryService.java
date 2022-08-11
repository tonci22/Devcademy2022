package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.domain.ReservationHistory;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;

import java.util.List;

public interface ReservationHistoryService {
    ReservationHistory add(Reservation reservation, ReservationUpdateDto reservationUpdateDto);
    List<ReservationHistory> getAll();
}
