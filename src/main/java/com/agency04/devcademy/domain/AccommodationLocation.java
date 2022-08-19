package com.agency04.devcademy.domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
public class AccommodationLocation {

    @Size(max = 100, message = "{size.title}")
    private String title;
    @Size(max = 150, message = "{size.subtitle}")
    private String subtitle;
}
