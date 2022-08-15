package com.agency04.devcademy.domain;

import com.agency04.devcademy.enums.ReservationType;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ReservationType type;
    private Timestamp checkIn;
    private Timestamp checkOut;
    private Integer personCount;
    private boolean submitted;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private Accommodation accommodation;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ReservationHistory> reservationHistories = new ArrayList<>();

    public Reservation() {
    }

    public Reservation(ReservationType type, Timestamp checkIn, Timestamp checkOut, Integer personCount, boolean submitted) {
        this.type = type;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.personCount = personCount;
        this.submitted = submitted;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", type=" + type +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", personCount=" + personCount +
                ", submitted=" + submitted +
                ", user=" + user +
                ", accommodation=" + accommodation +
                ", reservationHistories=" + reservationHistories +
                '}';
    }
}
