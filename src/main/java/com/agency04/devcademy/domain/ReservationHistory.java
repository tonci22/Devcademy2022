package com.agency04.devcademy.domain;

import com.agency04.devcademy.enums.ReservationType;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
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

}
