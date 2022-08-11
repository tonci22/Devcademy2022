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

}
