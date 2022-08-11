package com.agency04.devcademy.dto.mapper;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.domain.ReservationHistory;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.dto.response.ReservationHistoryDtoResponse;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ReservationHistoryMapper {

    public ReservationHistory mapToDtoAdd(Reservation reservation, ReservationUpdateDto reservationUpdateDto) {

        ReservationHistory reservationHistory = new ReservationHistory();
        reservationHistory.setIdReservation(reservation.getId());
        reservationHistory.setFromType(reservation.getType());
        reservationHistory.setToType(reservationUpdateDto.getType());
        reservationHistory.setEntryTimestamp(new Timestamp(new Date().getTime()));

        return reservationHistory;
    }

    public ReservationHistoryDtoResponse mapToDto(ReservationHistory reservationHistory){
        ReservationHistoryDtoResponse reservationHistoryDtoResponse = new ReservationHistoryDtoResponse();

        reservationHistoryDtoResponse.setId(reservationHistory.getId());
        reservationHistoryDtoResponse.setIdReservation(reservationHistory.getIdReservation());
        reservationHistoryDtoResponse.setFromType(reservationHistory.getFromType());
        reservationHistoryDtoResponse.setToType(reservationHistory.getToType());
        reservationHistoryDtoResponse.setEntryTimestamp(reservationHistory.getEntryTimestamp());

        return reservationHistoryDtoResponse;
    }

    public List<ReservationHistoryDtoResponse> mapToDto(List<ReservationHistory> reservationHistories){
        List<ReservationHistoryDtoResponse> reservationHistoryDtoResponses = new ArrayList<>();

        for (ReservationHistory reservationHistory : reservationHistories){
            reservationHistoryDtoResponses.add(mapToDto(reservationHistory));
        }

        return reservationHistoryDtoResponses;
    }
}
