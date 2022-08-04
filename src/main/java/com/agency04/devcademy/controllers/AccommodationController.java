package com.agency04.devcademy.controllers;

import com.agency04.devcademy.dto.mapper.AccommodationMapper;
import com.agency04.devcademy.dto.response.AccommodationDtoResponse;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    private final AccommodationService accommodationService;

    private final LocationService locationService;

    @Autowired
    private AccommodationMapper accommodationMapper;

    public AccommodationController(@Qualifier("accommodationServiceImpl") AccommodationService accommodationService,@Qualifier("locationServiceImpl") LocationService locationService) {
        this.accommodationService = accommodationService;
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<Collection<AccommodationDtoResponse>> getAccommodations() {
        return ResponseEntity.ok(accommodationMapper.mapToDto(accommodationService.getAll(), locationService.getAll()));
    }

    @PostMapping
    public ResponseEntity<AccommodationDtoResponse> createAccommodation(@RequestBody AccommodationCreateDto accommodationCreateDto) {
        return ResponseEntity.ok(accommodationMapper.mapToDto(accommodationService.add(accommodationCreateDto), locationService.add(accommodationCreateDto.getLocation())));
    }

    @PutMapping("{id}")
    public ResponseEntity<AccommodationDtoResponse> updateAccommodation(@RequestBody AccommodationUpdateDto accommodationUpdateDto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(accommodationMapper.mapToDto(accommodationService.updateAccommodation(id, accommodationUpdateDto), locationService.updateLocation(accommodationUpdateDto.getLocation().getId(), accommodationUpdateDto.getLocation())));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAccommodation(@PathVariable("id") Long id) {
        accommodationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
