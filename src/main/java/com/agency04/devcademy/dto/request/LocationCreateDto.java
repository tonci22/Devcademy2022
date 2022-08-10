package com.agency04.devcademy.dto.request;


import java.util.List;

public class LocationCreateDto {

    private String title;
    private String subtitle;
    private Integer postalCode;
    private List<AccommodationCreateDto> accommodation;
    public LocationCreateDto() {
    }

    public LocationCreateDto(String title, String subtitle, Integer postalCode) {
        this.title = title;
        this.subtitle = subtitle;
        this.postalCode = postalCode;
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

    public List<AccommodationCreateDto> getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(List<AccommodationCreateDto> accommodation) {
        this.accommodation = accommodation;
    }
}
