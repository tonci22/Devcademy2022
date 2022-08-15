package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.mapper.AccommodationMapper;
import com.agency04.devcademy.mapper.ReservationMapper;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;
    private final AccommodationService accommodationService;
    private final ReservationHistoryService reservationHistoryService;

    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private AccommodationMapper accommodationMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, AccommodationService accommodationService, ReservationHistoryService reservationHistoryService) {
        this.reservationRepository = reservationRepository;
        this.accommodationService = accommodationService;
        this.reservationHistoryService = reservationHistoryService;
    }

    @Override
    public Reservation add(ReservationCreateDto reservationCreateDto) {
        return reservationRepository.save(reservationMapper.mapDtoTo(reservationCreateDto));
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Long id, ReservationUpdateDto reservationUpdateDto) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation id not found"));
        reservationHistoryService.add(reservation, reservationUpdateDto);
        return reservationRepository.save(reservationMapper.mapDtoTo(id, reservationUpdateDto));
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation id not found"));
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation id not found"));
        reservationRepository.deleteById(id);
    }
}
