package com.agency04.devcademy.controllers;

import com.agency04.devcademy.dto.mapper.AccommodationMapper;
import com.agency04.devcademy.dto.response.AccommodationDtoResponse;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    private final AccommodationService accommodationService;

    @Autowired
    private AccommodationMapper accommodationMapper;

    public AccommodationController(@Qualifier("accommodationServiceImpl") AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public ResponseEntity<List<AccommodationDtoResponse>> getAccommodations() {
        return ResponseEntity.ok(accommodationMapper.mapToDto(accommodationService.getAll()));
    }

    @PostMapping
    public ResponseEntity<AccommodationDtoResponse> createAccommodation(@RequestBody AccommodationCreateDto accommodationCreateDto) {
        return ResponseEntity.ok(accommodationMapper.mapToDto(accommodationService.add(accommodationCreateDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<AccommodationDtoResponse> updateAccommodation(@RequestBody AccommodationUpdateDto accommodationUpdateDto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(accommodationMapper.mapToDto(accommodationService.updateAccommodation(id, accommodationUpdateDto)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccommodation(@PathVariable("id") Long id) {
        accommodationService.deleteById(id);
        return ResponseEntity.ok("DELETED ACCOMMODATION");
    }
}
