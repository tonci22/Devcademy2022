package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;

import java.util.Collection;

public interface LocationService {

    Location add(LocationCreateDto locationCreateDto);

    Location add(Location location);

    Collection<Location> addAll(Collection<Location> locations);

    Location getById(Long id);


    Collection<Location> getAll();

    Location updateLocation(Long id, LocationUpdateDto locationUpdateDto);

    void deleteById(Long id);

    void deleteAll();
}
