package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.repositories.AccommodationRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("accommodationServiceImpl")
public class AccommodationServiceImpl implements AccommodationService{
    private final AccommodationRepository accommodationRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public Accommodation add(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Collection<Accommodation> addAll(Collection<Accommodation> accommodations) {
        return accommodationRepository.saveAll(accommodations);
    }

    @Override
    public Collection<Accommodation> getAll() {
        return accommodationRepository.findAll();
    }
}
