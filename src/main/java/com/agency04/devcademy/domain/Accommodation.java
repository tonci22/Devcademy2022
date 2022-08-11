package com.agency04.devcademy.domain;

import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.enums.AccommodationType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 100)
    private String title;
    @Size(max = 200)
    private String subtitle;
    private String description;

    @Min(1)
    @Max(5)
    private Integer categorization;
    @Min(1)
    private Integer personCount;
    private String imageUrl;
    private boolean freeCancelation = true;
    private double price;
    private AccommodationType type;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    @OneToMany
    private List<Reservation> reservations;


    public Accommodation() {
    }

    public Accommodation(String title, String subtitle, String description) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
    }

    public void mapFrom(AccommodationUpdateDto accommodationUpdateDto) {

        this.setTitle(accommodationUpdateDto.getTitle());
        this.setSubtitle(accommodationUpdateDto.getSubtitle());
        this.setDescription(accommodationUpdateDto.getDescription());
        this.setCategorization(accommodationUpdateDto.getCategorization());
        this.setPersonCount(accommodationUpdateDto.getPersonCount());
        this.setImageUrl(accommodationUpdateDto.getImageUrl());
        this.setFreeCancelation(accommodationUpdateDto.isFreeCancelation());
        this.setPrice(accommodationUpdateDto.getPrice());
        this.setType(accommodationUpdateDto.getType());
    }

    public void mapFrom(AccommodationCreateDto accommodationCreateDto) {

        this.setTitle(accommodationCreateDto.getTitle());
        this.setSubtitle(accommodationCreateDto.getSubtitle());
        this.setDescription(accommodationCreateDto.getDescription());
        this.setCategorization(accommodationCreateDto.getCategorization());
        this.setPersonCount(accommodationCreateDto.getPersonCount());
        this.setImageUrl(accommodationCreateDto.getImageUrl());
        this.setFreeCancelation(accommodationCreateDto.isFreeCancelation());
        this.setPrice(accommodationCreateDto.getPrice());
        this.setType(accommodationCreateDto.getType());
    }

}
