package com.agency04.devcademy.dto.request;


import lombok.*;

import java.util.List;

@Data
public class LocationCreateDto {

    private String title;
    private String subtitle;
    private Integer postalCode;
    private List<AccommodationCreateDto> accommodations;
    public LocationCreateDto() {
    }

    public LocationCreateDto(String title, String subtitle, Integer postalCode) {
        this.title = title;
        this.subtitle = subtitle;
        this.postalCode = postalCode;
    }

}
