package com.agency04.devcademy.dto.request;

import lombok.*;

import java.util.List;

@Data
public class LocationUpdateDto {

    private Long id;

    private String title;
    private String subtitle;
    private Integer postalCode;
    private List<AccommodationUpdateDto> accommodations;
    public LocationUpdateDto() {
    }

    public LocationUpdateDto(String title, String subtitle, Integer postalCode) {
        this.title = title;
        this.subtitle = subtitle;
        this.postalCode = postalCode;
    }

}
