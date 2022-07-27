package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;

import java.util.Collection;

public interface AccommodationService {
    Accommodation add(Accommodation accommodation);
    Collection<Accommodation> addAll(Collection<Accommodation> accommodations);

    Collection<Accommodation> getAll();

}
