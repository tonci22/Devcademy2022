package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
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
}
