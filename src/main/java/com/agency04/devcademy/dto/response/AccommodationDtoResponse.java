package com.agency04.devcademy.dto.response;

import com.agency04.devcademy.enums.AccommodationType;


import java.util.List;
import java.util.Objects;

public class AccommodationDtoResponse {

    private Long id;
    private String title;
    private String subtitle;
    private String description;
    private Integer categorization;
    private Integer personCount;
    private String imageUrl;
    private boolean freeCancelation = true;
    private double price;
    private AccommodationType type;

    public AccommodationDtoResponse() {
    }

    public AccommodationDtoResponse(String title, String subtitle, String description, Integer categorization, Integer personCount, String imageUrl) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.categorization = categorization;
        this.personCount = personCount;
        this.imageUrl = imageUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategorization() {
        return categorization;
    }

    public void setCategorization(Integer categorization) {
        this.categorization = categorization;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFreeCancelation() {
        return freeCancelation;
    }

    public void setFreeCancelation(boolean freeCancelation) {
        this.freeCancelation = freeCancelation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AccommodationType getType() {
        return type;
    }

    public void setType(AccommodationType type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccommodationDtoResponse that = (AccommodationDtoResponse) o;
        return freeCancelation == that.freeCancelation && Double.compare(that.price, price) == 0 && Objects.equals(title, that.title) && Objects.equals(subtitle, that.subtitle) && Objects.equals(description, that.description) && Objects.equals(categorization, that.categorization) && Objects.equals(personCount, that.personCount) && Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, subtitle, description, categorization, personCount, imageUrl, freeCancelation, price);
    }
}
