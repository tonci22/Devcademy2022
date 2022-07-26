package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.enums.ReservationType;
import lombok.*;

import java.sql.Timestamp;

@Data
public class ReservationHistoryCreateDto {
    private Timestamp entryTimestamp;
    private ReservationType fromType;
    private ReservationType toType;
    private Long idReservation;

    public ReservationHistoryCreateDto() {
    }

    public ReservationHistoryCreateDto(Timestamp entryTimestamp, ReservationType fromType, ReservationType toType, Long idReservation) {
        this.entryTimestamp = entryTimestamp;
        this.fromType = fromType;
        this.toType = toType;
        this.idReservation = idReservation;
    }
}
