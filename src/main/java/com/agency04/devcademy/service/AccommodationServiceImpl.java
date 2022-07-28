package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.AccommodationCreateDto;
import com.agency04.devcademy.dto.AccommodationUpdateDto;
import com.agency04.devcademy.enums.AccommodationType;
import com.agency04.devcademy.repositories.AccommodationRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service("accommodationServiceImpl")
public class AccommodationServiceImpl implements AccommodationService{
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

        Accommodation accommodation = new Accommodation(accommodationCreateDto.getTitle(),
                accommodationCreateDto.getSubtitle(), accommodationCreateDto.getDescription(), accommodationCreateDto.getCategorization(),
                accommodationCreateDto.getPersonCount(), accommodationCreateDto.getImageUrl(), accommodationCreateDto.isFreeCancelation(),
                accommodationCreateDto.getPrice(), accommodationCreateDto.getType());

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
    public Accommodation updateAccommodation(Accommodation accommodation, AccommodationUpdateDto accommodationUpdateDto) {

        accommodation.setTitle(accommodationUpdateDto.getTitle());
        accommodation.setSubtitle(accommodationUpdateDto.getSubtitle());
        accommodation.setDescription(accommodationUpdateDto.getDescription());
        accommodation.setCategorization(accommodationUpdateDto.getCategorization());
        accommodation.setPersonCount(accommodationUpdateDto.getPersonCount());
        accommodation.setImageUrl(accommodationUpdateDto.getImageUrl());
        accommodation.setFreeCancelation(accommodationUpdateDto.isFreeCancelation());
        accommodation.setPrice(accommodationUpdateDto.getPrice());
        accommodation.setType(accommodationUpdateDto.getType());

        accommodationRepository.save(accommodation);

        return accommodation;

    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }
}
