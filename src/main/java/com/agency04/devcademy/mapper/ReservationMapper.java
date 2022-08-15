package com.agency04.devcademy.mapper;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.dto.response.ReservationDtoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    Reservation mapDtoTo(ReservationCreateDto reservationCreateDto);
    ReservationDtoResponse mapDtoToResponse(ReservationCreateDto reservationCreateDto);
    Reservation mapDtoTo(Long id, ReservationUpdateDto reservationUpdateDto);
    ReservationDtoResponse mapDtoTo(Reservation reservation);
    ReservationCreateDto mapDtoToReservation(Reservation reservation);
    List<ReservationDtoResponse> mapDtoTo(List<Reservation> reservations);
}
