package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.mapper.AccommodationMapper;
import com.agency04.devcademy.repositories.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final AccommodationService accommodationService;

    private AccommodationMapper accommodationMapper;

    @Override
    public Location add(LocationCreateDto locationCreateDto) {

        Location location = new Location();
        location.mapFrom(locationCreateDto);
        locationRepository.save(location);

        return location;
    }

    @Override
    public Location add(LocationUpdateDto locationUpdateDto) {

        Location location = new Location();
        location.mapFrom(locationUpdateDto);
        locationRepository.save(location);

        return location;
    }

    @Override
    public List<Location> addAll(Collection<Location> locations) {
        return locationRepository.saveAll(locations);
    }

    @Override
    public Location getById(Long id) {
        return locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found"));
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location updateLocation(Long id, LocationUpdateDto locationUpdateDto) {

        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found"));
        location.mapFrom(locationUpdateDto, id);
        return locationRepository.save(location);
    }

    @Override
    public void deleteById(Long id) {
        locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location id not found"));
        locationRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        locationRepository.deleteAll();
    }

    //accommodation

    @Override
    public Location addAccommodation(Long id, AccommodationCreateDto accommodationCreateDto) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location ID not found"));
        Accommodation accommodation = accommodationService.add(accommodationCreateDto);
        location.getAccommodations().add(accommodation);
        return locationRepository.save(location);
    }

    @Override
    public Location addAccommodation(Long id, List<AccommodationCreateDto> accommodationCreateDtos) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location ID not found"));
        for (AccommodationCreateDto accommodationCreateDto : accommodationCreateDtos){
            addAccommodation(id, accommodationCreateDto);
        }
        return location;
    }

    @Override
    public Location updateAccommodation(Long idLocation,Long idAccommodation, AccommodationUpdateDto accommodationUpdateDto) {
        Location location = locationRepository.findById(idLocation).orElseThrow(() -> new ResourceNotFoundException("Location ID not found"));
        accommodationService.getById(idAccommodation);

        Accommodation accommodation = accommodationMapper.mapToDtoUpdate(idAccommodation, accommodationUpdateDto);

        accommodationService.add(accommodationMapper.mapToDtoAccommodation(accommodation));
        return locationRepository.save(location);
    }

    @Override
    public void deleteById(Long idLocation, Long idAccommodation) {
        Location location = locationRepository.findById(idLocation).orElseThrow(() -> new ResourceNotFoundException("Location ID not found"));
        accommodationService.deleteById(idAccommodation);
        locationRepository.save(location);
    }
}
