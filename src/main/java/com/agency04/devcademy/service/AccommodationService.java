package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;

import java.util.List;
import java.util.Set;

public interface AccommodationService {

    Accommodation getById(Long id);

    List<Accommodation> findByCategorizationAndPersonCountGreaterThanEqual(Integer categorization, Integer personCount);

    Accommodation add(Accommodation accommodation);
    Accommodation add(AccommodationCreateDto accommodation);

    List<Accommodation> addAll(List<Accommodation> accommodations);

    Set<Accommodation> randomizeAccommodations();

    List<Accommodation> getAll();

    Accommodation updateAccommodation(Long id, AccommodationUpdateDto accommodation);

    void deleteById(Long id);
}
