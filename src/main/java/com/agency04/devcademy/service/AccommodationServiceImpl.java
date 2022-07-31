package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.AccommodationCreateDto;
import com.agency04.devcademy.dto.AccommodationUpdateDto;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.repositories.AccommodationRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Primary
@Service("accommodationServiceImpl")
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public Optional<Accommodation> getById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Accommodation add(AccommodationCreateDto accommodationCreateDto) {

        Accommodation accommodation = new Accommodation();
        accommodation.mapFrom(accommodationCreateDto);
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

    @Override
    public Accommodation updateAccommodation(Long id, AccommodationUpdateDto accommodationUpdateDto) {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accommodation not found"));
        accommodation.mapFrom(accommodationUpdateDto);

        accommodationRepository.save(accommodation);

        return accommodation;
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accommodation not found"));
        accommodationRepository.deleteById(id);
    }
}
