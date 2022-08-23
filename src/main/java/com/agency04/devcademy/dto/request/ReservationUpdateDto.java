package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.enums.ReservationType;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReservationUpdateDto {

    private ReservationType type;
    private Timestamp checkIn;
    private Timestamp checkOut;
    private Integer personCount;
    private boolean submitted;
    private AccommodationUpdateDto accommodation;

}
