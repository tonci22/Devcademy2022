package com.agency04.devcademy.controllers;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.dto.mapper.AccommodationMapper;
import com.agency04.devcademy.dto.mapper.LocationMapper;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.dto.response.LocationDtoResponse;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        return ResponseEntity.ok(locationMapper.mapToDto(locationService.add(locationCreateDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<LocationDtoResponse> updateLocation(@RequestBody LocationUpdateDto locationUpdateDto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(locationMapper.mapToDto(locationService.updateLocation(id, locationUpdateDto)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable("id") Long id) {
        locationService.deleteById(id);
        return ResponseEntity.ok("DELETED LOCATION");
    }

    //accommodation

    @PostMapping(value = "/{id}/accommodations")
    public ResponseEntity<Location> createAccommodation(@PathVariable("id") Long id, @RequestBody List<AccommodationCreateDto> accommodationCreateDto){
        return ResponseEntity.ok(locationService.addAccommodation(id, accommodationCreateDto));
    }

    @PutMapping(value = "/{id}/accommodations/{idAccommodation}")
    public ResponseEntity<Location> updateAccommodation(@PathVariable("id") Long idLocation, @PathVariable("idAccommodation") Long idAccommodation, @RequestBody AccommodationUpdateDto accommodationUpdateDto){
        return ResponseEntity.ok(locationService.updateAccommodation(idLocation, idAccommodation, accommodationUpdateDto));
    }

    //todo - vratit se na ovo jer ne radi
    @DeleteMapping(value = "/{id}/accommodations/{idAccommodation}")
    public ResponseEntity<String> updateAccommodation(@PathVariable("id") Long idLocation, @PathVariable("idAccommodation") Long idAccommodation){
        accommodationService.deleteById(idAccommodation);
        return ResponseEntity.ok("DELETED ACCOMMODATION");
    }
}