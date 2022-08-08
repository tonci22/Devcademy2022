package com.agency04.devcademy.domain;

import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"title", "postalCode"})})
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    private String title;
    @Size(max = 150)
    private String subtitle;
    @Max(5)
    private Integer postalCode;
    @OneToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    public Location() {
    }

    public Location(String title, String subtitle, Integer postalCode) {
        this.title = title;
        this.subtitle = subtitle;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void mapFrom(LocationCreateDto locationCreateDto) {
        this.setId(locationCreateDto.getId());
        this.setTitle(locationCreateDto.getTitle());
        this.setSubtitle(locationCreateDto.getSubtitle());
        this.setPostalCode(locationCreateDto.getPostalCode());
    }

    public void mapFrom(LocationUpdateDto locationUpdateDto, Long id) {
        this.setId(id);
        this.setTitle(locationUpdateDto.getTitle());
        this.setSubtitle(locationUpdateDto.getSubtitle());
        this.setPostalCode(locationUpdateDto.getPostalCode());
    }

    public void mapFrom(LocationUpdateDto locationUpdateDto) {
        this.setId(locationUpdateDto.getId());
        this.setTitle(locationUpdateDto.getTitle());
        this.setSubtitle(locationUpdateDto.getSubtitle());
        this.setPostalCode(locationUpdateDto.getPostalCode());
    }
}
