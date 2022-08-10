package com.agency04.devcademy.service;


import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.dto.mapper.ReservationMapper;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation add(ReservationCreateDto reservation) {
        return reservationRepository.save(reservationMapper.mapToDto(reservation));
    }

    @Override
    public List<Reservation> addAll(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Long id, ReservationUpdateDto reservation) {
        reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));
        Reservation tempReservation = reservationMapper.mapToDto(reservation);
        return reservationRepository.save(tempReservation);
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));
        reservationRepository.deleteById(id);
    }
}
