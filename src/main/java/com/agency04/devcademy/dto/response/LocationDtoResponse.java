package com.agency04.devcademy.dto.response;

import lombok.*;

import java.util.List;

@Data
public class LocationDtoResponse {

    private Long id;
    private String title;
    private String subtitle;
    private Integer postalCode;
    private List<AccommodationDtoResponse> accommodations;

    public LocationDtoResponse() {
    }

    public LocationDtoResponse(String title, String subtitle, Integer postalCode) {
        this.title = title;
        this.subtitle = subtitle;
        this.postalCode = postalCode;
    }
}
