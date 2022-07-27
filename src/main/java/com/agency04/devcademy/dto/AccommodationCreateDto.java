package com.agency04.devcademy.dto;

public class AccommodationCreateDto {
    private String name;

    public AccommodationCreateDto(){
    }

    public AccommodationCreateDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
