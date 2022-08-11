package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.domain.ReservationHistory;
import com.agency04.devcademy.dto.mapper.ReservationHistoryMapper;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.repositories.ReservationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationHistoryServiceImpl implements ReservationHistoryService {

    private final ReservationHistoryRepository reservationHistoryRepository;

    @Autowired
    private ReservationHistoryMapper reservationHistoryMapper;

    public ReservationHistoryServiceImpl(ReservationHistoryRepository reservationHistoryRepository) {
        this.reservationHistoryRepository = reservationHistoryRepository;
    }

    @Override
    public ReservationHistory add(Reservation reservation, ReservationUpdateDto reservationUpdateDto) {
        return reservationHistoryRepository.save(reservationHistoryMapper.mapToDtoAdd(reservation, reservationUpdateDto));
    }

    @Override
    public List<ReservationHistory> getAll() {
        return reservationHistoryRepository.findAll();
    }
}
