package com.agency04.devcademy.dto.request;

import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public List<AccommodationUpdateDto> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(List<AccommodationUpdateDto> accommodations) {
        this.accommodations = accommodations;
    }
}
