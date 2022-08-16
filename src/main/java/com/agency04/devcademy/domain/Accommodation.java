package com.agency04.devcademy.domain;

import com.agency04.devcademy.enums.AccommodationType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Data
@Entity
public class Accommodation extends AccommodationLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @Min(1)
    @Max(5)
    private Integer categorization;

    @Min(1)
    private Integer personCount;

    @Lob
    private Byte[] image;

    private boolean freeCancelation = true;
    private double price;
    private AccommodationType type;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Reservation> reservations;


    public Accommodation() {
    }

    public Accommodation(String title, String subtitle, String description) {
        this.setTitle(title);
        this.setSubtitle(subtitle);
        this.description = description;
    }
}
