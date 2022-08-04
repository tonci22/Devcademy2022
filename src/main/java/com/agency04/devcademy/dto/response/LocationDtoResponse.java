package com.agency04.devcademy.dto.response;


public class LocationDtoResponse {

    private Long id;
    private String name;
    private Integer postalCode;
    public LocationDtoResponse() {
    }

    public LocationDtoResponse(String name, Integer postalCode) {
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



}
