package com.agency04.devcademy.dto;

import com.agency04.devcademy.enums.AccommodationType;

import javax.validation.constraints.Size;
import java.util.Objects;

public class AccommodationUpdateDto {

    @Size(max = 100)
    private String title;
    @Size(max = 200)
    private String subtitle;
    private String description;
    @Size(min = 1, max = 5)
    private Integer categorization;
    @Size(min = 1)
    private Integer personCount;
    private String imageUrl;
    private boolean freeCancelation = true;
    private double price;
    private AccommodationType type;

    public AccommodationUpdateDto(){}

    public AccommodationUpdateDto(String title, String subtitle, String description, Integer categorization, Integer personCount, String imageUrl) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.categorization = categorization;
        this.personCount = personCount;
        this.imageUrl = imageUrl;
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
        AccommodationUpdateDto that = (AccommodationUpdateDto) o;
        return freeCancelation == that.freeCancelation && Double.compare(that.price, price) == 0 && Objects.equals(title, that.title) && Objects.equals(subtitle, that.subtitle) && Objects.equals(description, that.description) && Objects.equals(categorization, that.categorization) && Objects.equals(personCount, that.personCount) && Objects.equals(imageUrl, that.imageUrl) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, subtitle, description, categorization, personCount, imageUrl, freeCancelation, price, type);
    }
}
