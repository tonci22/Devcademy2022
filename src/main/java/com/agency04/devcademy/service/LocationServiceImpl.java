package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.mapper.AccommodationMapper;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final AccommodationService accommodationService;

    @Autowired
    private AccommodationMapper accommodationMapper;

    public LocationServiceImpl(LocationRepository locationRepository, AccommodationService accommodationService) {
        this.locationRepository = locationRepository;
        this.accommodationService = accommodationService;
    }

    @Override
    public Location add(LocationCreateDto locationCreateDto) {

        Location location = new Location();
        location.mapFrom(locationCreateDto);

        return locationRepository.save(location);
    }

    @Override
    public Location add(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location add(LocationUpdateDto locationUpdateDto) {

        Location location = new Location();
        location.mapFrom(locationUpdateDto);

        return locationRepository.save(location);
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
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location id not found"));
        Accommodation accommodation = accommodationService.add(accommodationCreateDto);
        location.getAccommodations().add(accommodation);
        return locationRepository.save(location);
    }

    @Override
    public Location addAccommodation(Long id, List<AccommodationCreateDto> accommodationCreateDtos) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location id not found"));
        for (AccommodationCreateDto accommodationCreateDto : accommodationCreateDtos){
            addAccommodation(id, accommodationCreateDto);
        }
        return location;
    }

    @Override
    public Location updateAccommodation(Long idLocation,Long idAccommodation, AccommodationUpdateDto accommodationUpdateDto) {
        Location location = locationRepository.findById(idLocation).orElseThrow(() -> new ResourceNotFoundException("Location idLocation not found"));
        Accommodation accommodation = accommodationService.getById(idAccommodation);
        accommodation.mapFrom(accommodationUpdateDto);

        accommodationService.add(accommodationMapper.mapToDtoAccommodation(accommodation));
        return locationRepository.save(location);
    }

    //todo - vratit se na ovo jer ne radi
    @Override
    public void deleteById(Long idLocation, Long idAccommodation) {
        Location location = locationRepository.findById(idLocation).orElseThrow(() -> new ResourceNotFoundException("Location idLocation not found"));
        //location.getAccommodations().remove(accommodationService.getById(idAccommodation));
        accommodationService.deleteById(idAccommodation);
        locationRepository.save(location);
    }
}
