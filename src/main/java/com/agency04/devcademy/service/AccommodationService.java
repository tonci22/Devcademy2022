package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.AccommodationUpdateDto;

import java.util.Collection;
import java.util.Optional;

public interface AccommodationService {

    Optional<Accommodation> getById(Long id);
    Accommodation add(Accommodation accommodation);

    Collection<Accommodation> addAll(Collection<Accommodation> accommodations);

    Collection<Accommodation> getAll();

    Accommodation updateAccommodation(Accommodation accommodation1, AccommodationUpdateDto accommodation);

    void deleteById(Long id);
}
