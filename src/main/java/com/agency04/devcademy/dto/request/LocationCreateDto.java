package com.agency04.devcademy.dto.request;

import com.agency04.devcademy.dto.response.AccommodationDtoResponse;

import javax.validation.constraints.Size;
import java.util.Set;

public class LocationCreateDto {

    private Long id;
    @Size(max = 150)
    private String name;
    private Integer postalCode;
    private Set<AccommodationDtoResponse> accommodationDtoRequests;
    public LocationCreateDto() {
    }

    public LocationCreateDto(String name, Integer postalCode) {
        this.name = name;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public Set<AccommodationDtoResponse> getAccommodationDtoRequests() {
        return accommodationDtoRequests;
    }

    public void setAccommodationDtoRequests(Set<AccommodationDtoResponse> accommodationDtoRequests) {
        this.accommodationDtoRequests = accommodationDtoRequests;
    }
}
