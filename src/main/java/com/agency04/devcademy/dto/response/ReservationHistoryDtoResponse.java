package com.agency04.devcademy.dto.response;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.enums.ReservationType;
import lombok.*;

import java.sql.Timestamp;

@Data
public class ReservationHistoryDtoResponse {

    private Long id;
    private Timestamp entryTimestamp;
    private ReservationType fromType;
    private ReservationType toType;
    private Long idReservation;

}
