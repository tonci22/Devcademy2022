package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.domain.ReservationHistory;
import com.agency04.devcademy.enums.ReservationType;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ReservationUpdateDto {

    private ReservationType type;
    private Timestamp checkIn;
    private Timestamp checkOut;
    private Integer personCount;
    private boolean submitted;
    private AccommodationUpdateDto accommodation;

}
