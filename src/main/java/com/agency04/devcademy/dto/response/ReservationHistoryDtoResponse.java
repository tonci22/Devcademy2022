package com.agency04.devcademy.dto.response;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.enums.ReservationType;

import java.sql.Timestamp;

public class ReservationHistoryDtoResponse {

    private Long id;
    private Timestamp entryTimestamp;
    private ReservationType fromType;
    private ReservationType toType;
    private Long idReservation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getEntryTimestamp() {
        return entryTimestamp;
    }

    public void setEntryTimestamp(Timestamp entryTimestamp) {
        this.entryTimestamp = entryTimestamp;
    }

    public ReservationType getFromType() {
        return fromType;
    }

    public void setFromType(ReservationType fromType) {
        this.fromType = fromType;
    }

    public ReservationType getToType() {
        return toType;
    }

    public void setToType(ReservationType toType) {
        this.toType = toType;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }
}
