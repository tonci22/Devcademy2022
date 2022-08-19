package com.agency04.devcademy.controllers;

import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.mapper.AccommodationMapper;
import com.agency04.devcademy.mapper.LocationMapper;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.dto.response.LocationDtoResponse;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    private final LocationServiceImpl locationService;
    private final AccommodationService accommodationService;

    @Autowired
    private LocationMapper locationMapper;

    public LocationController(@Qualifier("locationServiceImpl") LocationServiceImpl locationService,@Qualifier("accommodationServiceImpl") AccommodationService accommodationService) {
        this.locationService = locationService;
        this.accommodationService = accommodationService;
    }


    @GetMapping
    public ResponseEntity<Collection<LocationDtoResponse>> getLocation() {
        return ResponseEntity.ok(locationMapper.mapToDto(locationService.getAll()));
    }

    @PostMapping
    public ResponseEntity<LocationDtoResponse> createLocation(@RequestBody LocationCreateDto locationCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationMapper.mapToDto(locationService.add(locationCreateDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<LocationDtoResponse> updateLocation(@RequestBody LocationUpdateDto locationUpdateDto, @PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(locationMapper.mapToDto(locationService.updateLocation(id, locationUpdateDto)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable("id") Long id) {
        locationService.deleteById(id);
        return ResponseEntity.ok("DELETED LOCATION");
    }


    @PostMapping(value = "/{id}/accommodations")
    public ResponseEntity<LocationDtoResponse> createAccommodation(@PathVariable("id") Long id, @RequestBody List<AccommodationCreateDto> accommodationCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(locationMapper.mapToDto(locationService.addAccommodation(id, accommodationCreateDto)));
    }

    @PutMapping(value = "/{id}/accommodations/{idAccommodation}")
    public ResponseEntity<LocationDtoResponse> updateAccommodation(@PathVariable("id") Long idLocation, @PathVariable("idAccommodation") Long idAccommodation, @RequestBody AccommodationUpdateDto accommodationUpdateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(locationMapper.mapToDto(locationService.updateAccommodation(idLocation, idAccommodation, accommodationUpdateDto)));
    }

    @DeleteMapping(value = "/{id}/accommodations/{idAccommodation}")
    public ResponseEntity<String> deleteAccommodation(@PathVariable("id") Long idLocation, @PathVariable("idAccommodation") Long idAccommodation){
        accommodationService.deleteById(idAccommodation);
        return ResponseEntity.ok("DELETED ACCOMMODATION");
    }
}