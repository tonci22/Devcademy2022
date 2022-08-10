package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.enums.ReservationType;

import java.sql.Timestamp;

public class ReservationCreateDto {

    private ReservationType type;
    private Timestamp checkIn;
    private Timestamp checkOut;
    private Integer personCount;
    private boolean submitted;

    public ReservationCreateDto(ReservationType type, Timestamp checkIn, Timestamp checkOut, Integer personCount, boolean submitted) {
        this.type = type;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.personCount = personCount;
        this.submitted = submitted;
    }

    public ReservationCreateDto() {

    }

    public ReservationType getType() {
        return type;
    }

    public void setType(ReservationType type) {
        this.type = type;
    }

    public Timestamp getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
    }

    public Timestamp getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }
}
