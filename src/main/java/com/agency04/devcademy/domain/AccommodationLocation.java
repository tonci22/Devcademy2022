package com.agency04.devcademy.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
public class AccommodationLocation {

    @Size(max = 100)
    private String title;
    @Size(max = 150)
    private String subtitle;
}
