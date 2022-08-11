package com.agency04.devcademy.domain;

import com.agency04.devcademy.enums.ReservationType;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ReservationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp entryTimestamp;
    private ReservationType fromType;
    private ReservationType toType;

    private Long idReservation;
    @ManyToOne
    private Reservation reservation;

    public ReservationHistory() {
    }

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
