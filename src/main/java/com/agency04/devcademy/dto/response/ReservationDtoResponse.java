package com.agency04.devcademy.dto.response;

import com.agency04.devcademy.enums.ReservationType;
import lombok.*;

import java.sql.Timestamp;

@Data
public class ReservationDtoResponse {

    private Long id;
    private ReservationType type;
    private Timestamp checkIn;
    private Timestamp checkOut;
    private Integer personCount;
    private boolean submitted;
    private AccommodationDtoResponse accommodation;
}
