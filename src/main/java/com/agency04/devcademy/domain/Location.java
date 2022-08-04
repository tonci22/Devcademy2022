package com.agency04.devcademy.domain;

import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name","postalCode"})})
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 150)
    private String name;
    private Integer postalCode;

    @OneToMany(mappedBy = "location")
    private Set<Accommodation> accommodations;

    public Location() {
    }

    public Location(String name, Integer postalCode) {
        this.name = name;
        this.postalCode = postalCode;
    }

    public Location(String name, Integer postalCode, Set<Accommodation> accommodations) {
        this.name = name;
        this.postalCode = postalCode;
        this.accommodations = accommodations;
    }

    public Long getId() {
        return id;
    }

    public Set<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(Set<Accommodation> accommodations) {
        this.accommodations = accommodations;
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

    public void mapFrom(LocationUpdateDto locationUpdateDto){
        this.setId(locationUpdateDto.getId());
        this.setName(locationUpdateDto.getName());
        this.setPostalCode(locationUpdateDto.getPostalCode());
    }
}
