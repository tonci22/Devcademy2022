package com.agency04.devcademy.dto.response;

import com.agency04.devcademy.enums.AccommodationType;
import lombok.*;

@Data
public class AccommodationDtoResponse {

    private Long id;
    private String title;
    private String subtitle;
    private String description;
    private Integer categorization;
    private Integer personCount;
    private Byte[] image;
    private boolean freeCancelation = true;
    private double price;
    private AccommodationType type;

    public AccommodationDtoResponse() {
    }

    public AccommodationDtoResponse(String title, String subtitle, String description, Integer categorization, Integer personCount, Byte[] imageUrl) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.categorization = categorization;
        this.personCount = personCount;
        this.image = imageUrl;
    }
}
