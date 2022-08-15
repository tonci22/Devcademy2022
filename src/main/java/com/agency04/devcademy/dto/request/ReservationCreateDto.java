package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.enums.ReservationType;
import lombok.*;

import java.sql.Timestamp;
@Data
public class ReservationCreateDto {

    private ReservationType type;
    private Timestamp checkIn;
    private Timestamp checkOut;
    private Integer personCount;
    private boolean submitted;
    private AccommodationCreateDto accommodation;

    public ReservationCreateDto(ReservationType type, Timestamp checkIn, Timestamp checkOut, Integer personCount, boolean submitted) {
        this.type = type;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.personCount = personCount;
        this.submitted = submitted;
    }

    public ReservationCreateDto() {

    }
}
