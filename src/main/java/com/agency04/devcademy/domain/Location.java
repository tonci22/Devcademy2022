package com.agency04.devcademy.domain;

import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accommodation> accommodations = new ArrayList<>();

    public Location() {
    }

    public Location(String title, String subtitle, Integer postalCode) {
        this.title = title;
        this.subtitle = subtitle;
        this.postalCode = postalCode;
    }

    public void mapFrom(LocationCreateDto locationCreateDto) {
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

    public Location mapFrom(LocationUpdateDto locationUpdateDto) {
        this.setId(locationUpdateDto.getId());
        this.setTitle(locationUpdateDto.getTitle());
        this.setSubtitle(locationUpdateDto.getSubtitle());
        this.setPostalCode(locationUpdateDto.getPostalCode());

        return this;
    }
}
