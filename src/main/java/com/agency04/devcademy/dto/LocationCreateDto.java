package com.agency04.devcademy.dto;

import javax.validation.constraints.Size;

public class LocationCreateDto {

    @Size(max = 150)
    private String name;
    private Integer postalCode;

    public LocationCreateDto() {
    }

    public LocationCreateDto(String name, Integer postalCode) {
        this.name = name;
        this.postalCode = postalCode;
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
}
