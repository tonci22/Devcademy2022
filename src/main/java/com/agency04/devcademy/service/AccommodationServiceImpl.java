package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.repositories.AccommodationRepository;
import com.agency04.devcademy.repositories.LocationRepository;
import com.agency04.devcademy.repositories.ReservationRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service("accommodationServiceImpl")
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final LocationRepository locationRepository;
    private final ReservationRepository reservationRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, LocationRepository locationRepository, ReservationRepository reservationRepository) {
        this.accommodationRepository = accommodationRepository;
        this.locationRepository = locationRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Accommodation getById(Long id) {
        return accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accommodation not found"));
    }

    @Override
    public Accommodation add(AccommodationCreateDto accommodationCreateDto) {

        Accommodation accommodation = new Accommodation();
        accommodation.mapFrom(accommodationCreateDto);

        locationRepository.save(accommodation.getLocation());
        reservationRepository.saveAll(accommodation.getReservations());

        return accommodationRepository.save(accommodation);
    }

    @Override
    public List<Accommodation> addAll(List<Accommodation> accommodations) {
        return accommodationRepository.saveAll(accommodations);
    }

    @Override
    public List<Accommodation> getAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Accommodation updateAccommodation(Long id, AccommodationUpdateDto accommodationUpdateDto) {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accommodation not found"));
        accommodation.mapFrom(accommodationUpdateDto);

        locationRepository.save(accommodation.getLocation());
        reservationRepository.saveAll(accommodation.getReservations());
        accommodationRepository.save(accommodation);

        return accommodation;
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accommodation id not found"));
        accommodationRepository.deleteById(id);
    }
}
