package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.domain.ReservationHistory;
import com.agency04.devcademy.dto.request.ReservationHistoryCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.mapper.ReservationHistoryMapper;
import com.agency04.devcademy.repositories.ReservationHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationHistoryServiceImpl implements ReservationHistoryService {

    private final ReservationHistoryRepository reservationHistoryRepository;

    private ReservationHistoryMapper reservationHistoryMapper;

    @Override
    public ReservationHistory add(ReservationHistoryCreateDto reservationHistoryCreateDto) {
        return reservationHistoryRepository.save(reservationHistoryMapper.mapToDto(reservationHistoryCreateDto));
    }

    @Override
    public ReservationHistory add(Reservation reservation, ReservationUpdateDto reservationUpdateDto) {
        return reservationHistoryRepository.save(reservationHistoryMapper.mapToReservationHistory(reservation, reservationUpdateDto));
    }

    @Override
    public List<ReservationHistory> getAll() {
        return reservationHistoryRepository.findAll();
    }
}
