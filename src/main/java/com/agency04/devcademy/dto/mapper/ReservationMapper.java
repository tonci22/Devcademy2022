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

    public Reservation mapDtoTo(ReservationCreateDto reservationCreateDto){
        Reservation reservation = new Reservation();
        reservation.setType(reservationCreateDto.getType());
        reservation.setPersonCount(reservationCreateDto.getPersonCount());
        reservation.setCheckIn(reservationCreateDto.getCheckIn());
        reservation.setCheckOut(reservationCreateDto.getCheckOut());
        reservation.setSubmitted(reservationCreateDto.isSubmitted());

        return reservation;
    }

    public Reservation mapDtoTo(Long id, ReservationUpdateDto reservationUpdateDto){
        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setType(reservationUpdateDto.getType());
        reservation.setPersonCount(reservationUpdateDto.getPersonCount());
        reservation.setCheckIn(reservationUpdateDto.getCheckIn());
        reservation.setCheckOut(reservationUpdateDto.getCheckOut());
        reservation.setSubmitted(reservationUpdateDto.isSubmitted());

        return reservation;
    }

    public ReservationDtoResponse mapDtoTo(Reservation reservation){
        ReservationDtoResponse reservationDtoResponse = new ReservationDtoResponse();
        reservationDtoResponse.setId(reservation.getId());
        reservationDtoResponse.setType(reservation.getType());
        reservationDtoResponse.setPersonCount(reservation.getPersonCount());
        reservationDtoResponse.setCheckIn(reservation.getCheckIn());
        reservationDtoResponse.setCheckOut(reservation.getCheckOut());
        reservationDtoResponse.setSubmitted(reservation.isSubmitted());

        return reservationDtoResponse;
    }

    public ReservationCreateDto mapDtoToReservation(Reservation reservation){
        ReservationCreateDto reservationDtoResponse = new ReservationCreateDto();

        reservationDtoResponse.setType(reservation.getType());
        reservationDtoResponse.setPersonCount(reservation.getPersonCount());
        reservationDtoResponse.setCheckIn(reservation.getCheckIn());
        reservationDtoResponse.setCheckOut(reservation.getCheckOut());
        reservationDtoResponse.setSubmitted(reservation.isSubmitted());

        return reservationDtoResponse;
    }

    public List<ReservationDtoResponse> mapDtoTo(List<Reservation> reservations){
        List<ReservationDtoResponse> reservationDtoResponse = new ArrayList<>();

        for (Reservation reservation : reservations){
            reservationDtoResponse.add(mapDtoTo(reservation));
        }

        return reservationDtoResponse;
    }
}
