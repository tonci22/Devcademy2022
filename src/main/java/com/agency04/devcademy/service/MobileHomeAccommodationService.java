package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.AccommodationCreateDto;
import com.agency04.devcademy.dto.AccommodationUpdateDto;

import java.util.Collection;
import java.util.Optional;

public class MobileHomeAccommodationService implements AccommodationService{
    @Override
    public Optional<Accommodation> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Accommodation add(AccommodationCreateDto accommodation) {
        return null;
    }

    @Override
    public Collection<Accommodation> addAll(Collection<Accommodation> accommodations) {
        return null;
    }

    @Override
    public Collection<Accommodation> getAll() {
        return null;
    }

    @Override
    public Accommodation updateAccommodation(Long id, AccommodationUpdateDto accommodation) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
