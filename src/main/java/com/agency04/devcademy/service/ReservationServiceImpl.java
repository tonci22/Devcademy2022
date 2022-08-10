package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.dto.mapper.ReservationMapper;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation add(ReservationCreateDto reservationCreateDto) {
        return reservationRepository.save(reservationMapper.mapDtoTo(reservationCreateDto));
    }

    @Override
    public List<Reservation> addAll(List<ReservationCreateDto> reservationCreateDtos) {
        List<Reservation> reservations = new ArrayList<>();

        for (ReservationCreateDto reservationCreateDto : reservationCreateDtos){
            reservations.add(reservationMapper.mapDtoTo(reservationCreateDto));
        }

        return reservationRepository.saveAll(reservations);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Long id, ReservationUpdateDto reservationUpdateDto) {
        reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation id not found"));

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
