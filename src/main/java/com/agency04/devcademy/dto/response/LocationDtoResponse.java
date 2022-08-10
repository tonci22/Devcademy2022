package com.agency04.devcademy.dto.response;


import com.agency04.devcademy.domain.Reservation;

import java.util.List;

public class LocationDtoResponse {

    private Long id;
    private String title;
    private String subtitle;
    private Integer postalCode;
    private List<AccommodationDtoResponse> accommodation;
    private List<Reservation> reservations;

    public LocationDtoResponse() {
    }

    public LocationDtoResponse(String title, String subtitle, Integer postalCode) {
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

    public List<AccommodationDtoResponse> getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(List<AccommodationDtoResponse> accommodation) {
        this.accommodation = accommodation;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
