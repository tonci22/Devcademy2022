package com.agency04.devcademy.dto.mapper;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.dto.response.ReservationDtoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationMapper {

    public Reservation mapToDto(ReservationCreateDto reservationCreateDto){

        Reservation reservation = new Reservation();

        reservation.setId(reservationCreateDto.getId());
        reservation.setReservationType(reservationCreateDto.getReservationType());
        reservation.setAccommodation(reservationCreateDto.getAccommodation());
        reservation.setCheckIn(reservationCreateDto.getCheckIn());
        reservation.setSubmitted(reservationCreateDto.isSubmitted());
        reservation.setCheckOut(reservationCreateDto.getCheckOut());
        reservation.setPersonCount(reservationCreateDto.getPersonCount());

        return reservation;
    }

    public ReservationDtoResponse mapToDto(Reservation reservationResponse){

        ReservationDtoResponse reservation = new ReservationDtoResponse();

        reservation.setId(reservationResponse.getId());
        reservation.setReservationType(reservationResponse.getReservationType());
        reservation.setCheckIn(reservationResponse.getCheckIn());
        reservation.setSubmitted(reservationResponse.isSubmitted());
        reservation.setCheckOut(reservationResponse.getCheckOut());
        reservation.setPersonCount(reservationResponse.getPersonCount());

        return reservation;
    }

    public List<Reservation> mapToDto(List<ReservationCreateDto> reservationCreateDtos){
        List<Reservation> reservations = new ArrayList<>();

        for (ReservationCreateDto reservation : reservationCreateDtos) {
            reservations.add(mapToDto(reservation));
        }
        return reservations;
    }

    public List<ReservationDtoResponse> mapToDtoAccommodation(List<Reservation> accommodations){

        List<ReservationDtoResponse> reservationResponses = new ArrayList<>();

        for (Reservation reservation : accommodations){
            reservationResponses.add(mapToDto(reservation));
        }

        return reservationResponses;
    }

    public Reservation mapToDto(ReservationUpdateDto reservationUpdateDto){

        Reservation reservation = new Reservation();

        reservation.setId(reservationUpdateDto.getId());
        reservation.setReservationType(reservationUpdateDto.getReservationType());
        reservation.setAccommodation(reservationUpdateDto.getAccommodation());
        reservation.setCheckIn(reservationUpdateDto.getCheckIn());
        reservation.setSubmitted(reservationUpdateDto.isSubmitted());
        reservation.setCheckOut(reservationUpdateDto.getCheckOut());
        reservation.setPersonCount(reservationUpdateDto.getPersonCount());

        return reservation;
    }
}
