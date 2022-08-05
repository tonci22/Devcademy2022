package com.agency04.devcademy.domain;

import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "postalCode"})})
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 150)
    private String name;
    private Integer postalCode;


    @OneToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    public Location() {
    }

    public Location(String name, Integer postalCode) {
        this.name = name;
        this.postalCode = postalCode;
    }

    public Location(String name, Integer postalCode, Accommodation accommodation) {
        this.name = name;
        this.postalCode = postalCode;
        this.accommodation = accommodation;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void mapFrom(LocationCreateDto locationCreateDto) {
        this.setId(locationCreateDto.getId());
        this.setName(locationCreateDto.getName());
        this.setPostalCode(locationCreateDto.getPostalCode());
    }

    public void mapFrom(LocationUpdateDto locationUpdateDto, Long id) {
        this.setId(id);
        this.setName(locationUpdateDto.getName());
        this.setPostalCode(locationUpdateDto.getPostalCode());
    }

    public void mapFrom(LocationUpdateDto locationUpdateDto) {
        this.setId(locationUpdateDto.getId());
        this.setName(locationUpdateDto.getName());
        this.setPostalCode(locationUpdateDto.getPostalCode());
    }
}
