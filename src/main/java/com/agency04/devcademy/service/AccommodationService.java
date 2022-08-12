package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;

import java.util.List;

public interface AccommodationService {

    Accommodation getById(Long id);

    Accommodation add(AccommodationCreateDto accommodation);

    List<Accommodation> addAll(List<Accommodation> accommodations);

    List<Accommodation> getAll();

    Accommodation updateAccommodation(Long id, AccommodationUpdateDto accommodation);

    void deleteById(Long id);
}
