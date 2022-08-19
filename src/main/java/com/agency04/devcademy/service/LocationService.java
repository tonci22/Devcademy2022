package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;

import java.util.Collection;
import java.util.List;

public interface LocationService {

    Location add(LocationCreateDto locationCreateDto);

    Location add(LocationUpdateDto locationUpdateDto);

    List<Location> addAll(Collection<Location> locations);

    Location getById(Long id);


    Collection<Location> getAll();

    Location updateLocation(Long id, LocationUpdateDto locationUpdateDto);

    void deleteById(Long id);

    void deleteAll();

    Location addAccommodation(Long id, AccommodationCreateDto accommodationCreateDto);
    Location addAccommodation(Long id, List<AccommodationCreateDto> accommodationCreateDto);

    Location updateAccommodation(Long idLocation, Long idAccommodation, AccommodationUpdateDto accommodationUpdateDto);
    void deleteById(Long idLocation, Long idAccommodation);

}
